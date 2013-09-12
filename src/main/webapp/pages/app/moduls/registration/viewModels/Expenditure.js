define([
    "knockout",
    "jquery",    
    "text!./../templates/Expenditure.html",
    "core",
    "vent",
    "dataTable"
    ], function(ko, $,  template, core, vent){


    var Expenditure = core.Model.extend({
        url : '/api/expenditure',
        autoUpdate : true,
        fields : {
          id : {},
          expenditureType: { default: { id : undefined }},
          companyName : {},
          member : { default: { id : undefined }},
          frequency : { default: undefined},
          bankAccount: { default: { id : undefined }},
          active: { default : false },
          paidFromAC : {},
          cost : { default : 0, validation : { pattern: /^\d{1,9}$/ }}
        }
      });

    return function(model){
        var self = this;
        self.oTable = oTable= ko.observable();

        self.showCategories = function(){
          vent.trigger('showCategories');
        }

        self.selectedCategory = ko.observable(null);
        self.categories = ko.observableArray(model.categories);
        
        self.expenditureTypeId = ko.observable();
        self.expenditureTypes = ko.observableArray([]);

        self.bankAccounts = ko.utils.arrayMap(model.bankaccount, function(b){
          return { id : b.id , name : (b.bank ? b.bank.name : '-') + ' ' + (b.accountType ? b.accountType.name : '-') };
        })

        self.selectedCategory.subscribe(function(){
            if (self.selectedCategory())
              return self.expenditureTypes(self.selectedCategory().expenditureTypes);
            else
              return self.expenditureTypes([]);
        });


        self.allExpenditureTypes = ko.observableArray(model.expendituretypes);
        $.get('/api/expenditure/expendituretypes', self.allExpenditureTypes);
        self.frequencyList = ko.observableArray(model.frequency);
        self.daysList = ko.observableArray(model.day); 
        self.members = ko.observableArray(model.members);

        Expenditure.on('delete create', function(){
          oTable().fnReloadAjax();
          vent.trigger('update_total');
        })
        .on('update', function(){
          vent.trigger('update_total');
        });

        self.onRemove = function(){
          Expenditure.off('delete create update');
        }

        self.add = function(){
          new Expenditure({ 
            member : self.members()[0]
          }).save();
       }
        self.delete = function(row){
            row.delete();
        }


        self.columns = [
{
  "sTitle": "Do you have this cost?", "sWidth": "10%" ,"sClass": "butons-action", 
  "mData": function (source, type, val) { return null; }, "bSortable": false 
},
{
    "sTitle": "Expenditure type", "sWidth": "10%", "sClass": "butons-action",
    "mData": function (source, type, val) { return null; }, "bSortable": false
},
{
  "sTitle": "Company name", "sClass": "butons-action", 
  "mData": function (source, type, val) {  return null;}, "bSortable": false
},

{
  "sTitle": "Whose cost?", "sClass": "butons-action", "oDefault": "" ,
  "mData": function (source, member, val) {return null;}, "bSortable": false
},
{
  "sTitle": "Frequency", "sClass": "butons-action", 
  "mData": function (source, member, val) { return null;}, "bSortable": false
},
{
  "sTitle": "Cost", "sClass": "butons-action", 
  "mData": function (source, type, val) { return null; }, "bSortable": false
},
{
     "sTitle": "Paid from A/C", "mData": function (source, type, val) { return null; }, "bSortable": false
},
{
  "sTitle": "Additional questions", "mDataProp": "question", "sWidth": "10%" ,"oDefault": "", "bSortable": false  
},
{
  "sTitle": "&nbsp;", "mDataProp": "question", "bSortable": false
}
        ];

        self.buildRow = function(data){
          return new Expenditure(data);
        }

        self.template = template;
    }
});