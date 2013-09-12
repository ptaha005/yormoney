define([
    "knockout",
    "jquery",    
    "text!./../templates/CategoriesPopup.html"
    ], function(ko, $,  template){

    return function(model){
        var self = this;

        self.items = ko.observableArray(model);
 
        self.afterRender = function(){
            $('#myModal').modal('show');
        }

        self.template = template;
    }
});