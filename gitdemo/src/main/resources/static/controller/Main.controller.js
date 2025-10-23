sap.ui.define(["sap/ui/core/mvc/Controller",
			   "jquery.sap.global",
			   "arum/util/service",
			   "sap/m/MessageBox"
], function(Controller, jQuery, service, MessageBox){
	return Controller.extend("arum.controller.Main",{
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"postPayload": {
					"companyName": "",
					"contactName": "",
					"status": "",
					"regDate": "2025-09-05T06:51:38.752+00:00"
				},
				"vendor":{}
			})
			sap.ui.getCore().setModel(oModel);
		},
		onSave: function(){
			var oModel = sap.ui.getCore().getModel();
			var payload = oModel.getProperty("/postPayload");
			service.callService("/vendor","POST",payload).then(function(){
				MessageBox.confirm("Saved");
			}).catch(function(){
				MessageBox.error("Failed");
			});
		},
		onClick: function(){
			
			var that = this;
			service.callService("/vendor","GET",{}).then(function(data){
				var oTable = that.getView().byId("idTable");
				var oModel = sap.ui.getCore().getModel();
				oModel.setProperty("/vendor",data._embedded.vendor);
				oTable.bindRows("/vendor");
			}).catch(function(){
				
			});
			
/*			jQuery.ajax("/newVendor",{
				type: "GET",
				success: function(data){
					var oTable = that.getView().byId("idTable");
					var oModel = new sap.ui.model.json.JSONModel();
					oModel.setData(data._embedded);
					sap.ui.getCore().setModel(oModel);
					oTable.bindRows("/vendor");
				},
				error: function(err){
					
				}
			})*/
			/*alert("Welcome 2");*/
		},
		
		onDelete: function(){
			var iIndex = this.getView().byId("idTable").getSelectedIndex();
			var sPath = this.getView().byId("idTable").getContextByIndex(iIndex).getPath();
			service.callService(sPath,"DELETE",{}).then(function(){
				MessageBox.confirm("Deleted Successfully");
			}).catch(function(){
				MessageBox.error("Deletion Failed");
			})
			
		}
	})
})