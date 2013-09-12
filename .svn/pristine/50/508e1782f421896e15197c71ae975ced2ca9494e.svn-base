define([
    "knockout",
    "jquery",    
    "text!./../templates/Income.html",
    "core",
    "vent",
    "ko.dataTable"
    ], function(ko, $,  template, core, vent){

    var Income = core.Model.extend({
        url : '/api/income',
        autoUpdate : true,
        fields : {
          id : {},
          active : {},
          incomeType : { default: { id : undefined }},
          member : { default: { id : undefined }},
          frequency : {},
          question : { default : 'N/A'},
          bankAccount : { default: { id : undefined }},
          incomeSource : {},
          amount : { default : 0,  validation : { pattern: /^\d{1,9}$/ }}
        }
      });
  
    return function(model){
        var self = this;

        self.incomeTypeId = ko.observable();
        self.incomeTypes = ko.observableArray(model.incometypes);
        self.frequencyList = ko.observableArray(model.frequency);
        self.daysList = ko.observableArray(model.day); 
        self.members = ko.observableArray(model.members||[]);

        //TODO : fix server ( add fiels for b.bank.name  + ' ' + b.accountType.name, change filter
        var banks = ko.utils.arrayFilter(model.bankaccount, function(b){ return b.bank !=null && b.accountType !=null; });
        self.bankAccounts = ko.utils.arrayMap(banks, function(b){
          return { id : b.id , name : b.bank.name  + ' ' + b.accountType.name  };
        });

        Income.on('delete create', function(){
          oTable().fnReloadAjax();
          vent.trigger('update_total');
        })
        .on('update', function(){
          vent.trigger('update_total');
        });

        self.onRemove = function(){
          Income.off('delete create update');
        }

        self.add = function(){
            new Income({ 
               member : self.members()[0]
            }).save();
        }

        self.oTable = oTable= ko.observable();
        
         self.delete = function(row){
            row.delete();
         }

        self.columns = [
            { 
              "sTitle": "Do you have this cost?", "sWidth": "10%", "sClass": "butons-action", 
              "mData": function (source, type, val) { return null; }, "bSortable": false
            },
            {
              "sTitle": "income type", "sWidth": "10%", "sClass": "butons-action",
              "mData": function (source, type, val) { return null; }, "bSortable": false
            },
            {"sTitle": "Income source", "mData": function (source, type, val) { return null; } , "bSortable": false }  ,
            {"sTitle": "Whose Income?", "mData": function (source, type, val) { return null; }  , "bSortable": false },
            {"sTitle": "Frequency", "mData": function (source, type, val) { return null; }  , "bSortable": false }  ,
            {"sTitle": "Amount", "mData": function (source, type, val) { return null; }   , "bSortable": false }  ,
            {"sTitle": "Paid to A/C", "mData": function (source, type, val) { return null; } , "bSortable": false },
            {"sTitle": "Additional questions", "mData": function (source, type, val) { return null; } , "bSortable": false },
            {"sTitle": "&nbsp;", "mData": function (source, type, val) { return null; } , "bSortable": false },
        ];

        self.buildRow = function(data){
          return new Income(data);
        }
        
        self.template = template;
    }
});