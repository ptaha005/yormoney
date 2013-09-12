define([
    "knockout",
    "jquery",    
    "text!./../../templates/Layouts/Layout.html",
    "vent"
    ], function(ko, $,  template, vent){

    return function(model){
        var self = this;
        self.content = ko.region();
        self.title = ko.observable(model.title);
        
        //banners
        self.bottom = ko.observable();
        self.middle = ko.observable();
        self.small1 = ko.observable();
        self.small2 = ko.observable();

        self.exit = function(){
            vent.trigger('logout');
        }

        self.budget = ko.observable();
        self.actual = ko.observable();

        self.afterRender = function(){
            $.get('/user/total', function(r){
                self.budget(r.In);
                self.actual(r.Result);
            });

            $.get('page/banner/' + model.page, function(r){
                self.bottom(r.bottom);
                self.middle(r.middle);
                self.small1(r.small1);
                self.small2(r.small2);
            });
        }

        self.template = template;
    }
});