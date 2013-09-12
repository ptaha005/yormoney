define([
    "knockout",
    "jquery",    
    "text!./../../templates/Layouts/GridLayout.html",
    "vent"
    ], function(ko, $,  template, vent){

    return function(model){
        var self = this;
        
        self.total = ko.observable(2500);
        self.title = model.title; 
        self.content = ko.region();
        self.next = function(){
            vent.trigger('update_state', model.fromPage);
        }

        self.exit = function(){
            vent.trigger('logout');
        }

        self.home = function(){
            $.get('/api/user/state', function(page){
                vent.trigger('next', page);
            });
        }

        self.showGuides = function(){
            vent.trigger('showGuides', model.fromPage);
        }

        self.showHowToVidio = function(){
            vent.trigger('showHowToVidio', model.fromPage);
        }

        vent.on('update_total', function(e, total){
            $.get('/user/total', function(r){
                self.total(r.Result);    
            });
        });

        self.onRemove = function(){
            vent.off('update_total');
        }

        self.afterRender = function(){
            vent.trigger('update_total');
        }

        self.template = template;
    }
});