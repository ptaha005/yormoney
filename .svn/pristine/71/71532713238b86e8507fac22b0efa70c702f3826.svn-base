define([
    "jquery",
    "knockout", 
    "vent" ,   
    "./viewModels/Register1",
    "./viewModels/Results",
    "./viewModels/Login",
    "./viewModels/CategoriesPopup",
    "./viewModels/Layouts/GridLayout",
    "./viewModels/Layouts/Layout",
    "./viewModels/Guides",
    "./viewModels/HowToVidio",
    "./viewModels/Forgot",
    "./viewModels/TermsAndConditions",
    "./viewModels/DemoPage",
    "core"
],function($, ko, vent, 
    Register1, 
    Results, 
    Login, 
    CategoriesPopup, 
    GridLayout, Layout, Guides, HowToVidio, Forgot, TermsAndConditions,
    DemoPage,
    core) {
    var content = ko.region();
    var popup = ko.region();
    var current_user = false;

    vent.on('error', function(){
        window.location = '#/login';
    });
    
    vent.on('next', function(e, from){
        if (from == 'login') window.location = '#/registration1';
        if (from == 'register1') window.location = '#/welcome';
        if (from == 'welcome') window.location = '#/registration2';
        if (from == 'register2') window.location = '#/bankaccounts';
        if (from == 'bankaccounts') window.location = '#/income';
        if (from == 'income') window.location = '#/expenditure';
        if (from == 'expenditure') window.location = '#/events'; 
        if (from == 'events') window.location = '#/summary';         
        if (from == 'summary') window.location = '#/complete';
        if (from == 'complite') window.location = '#/home';
        if (from == 'tasks') window.location = '#/home';
    });

    vent.on('update_state', function(e, from){        
        $.get('/user/state/' + from, function(){ //todo : fix server
            vent.trigger('next', from);    
        }).done(function(){
            
        }).fail(function(){
            vent.trigger('next', from); 
        });
    })

    vent.on('showTerms', function(){
        popup.render(TermsAndConditions);
    })

    vent.on('showGuides', function(e, page){
        popup.render(Guides, '/api/page/manual/' + page);
    })

    vent.on('showHowToVidio', function(e, page){
        popup.render(HowToVidio, '/api/page/video/' + page);
    })

    vent.on('showCategories', function(){
        popup.render(CategoriesPopup, '/api/expenditure/total');
    });

    var showForgot = function(what){
        content.render(Forgot, { what : what });
    }

    var showRegistration = function(){
        content.render(Register1);
    }

    var showResult = function(){
        content.render(Results);
    }

    var showDemoPage = function(){
        content.render(DemoPage);
    }


    var showLogin = function(){
        content.render(Login);
    }

    var checke_autorizetion = function(allow_routes){
        return function(callback){
            var that = this;
            
            if (current_user || allow_routes.indexOf(this.path)!=-1)
                callback();
            else
            {
                $.getJSON('/user/session', function(json) {
                    if (json.jsonValues.login) {
                        current_user = json;

                        callback();
                    } else {
                        current_user = false;
                        that.redirect('#/login');
                    }
                });
            }
        }
    }

    var redirect_to_user_state = function(){
        if (!!current_user) {
                vent.trigger('next', current_user.describeState);
        }
        else
            showLogin();
    }

    vent.on('logout', function(){ 
        $.get('/api/user/logout', function(){
            current_user = false;
            window.location = '#/login';       
        });
    });

    return {
        content : content,
        popup : popup,
        showRegistration : showRegistration,
        showResult : showResult,
        showLogin : showLogin,
        showForgot : showForgot,

        
        current_user : current_user,
        
        showDemoPage : showDemoPage,

        checke_autorizetion : checke_autorizetion,
        redirect_to_user_state : redirect_to_user_state,

        GridLayout : GridLayout,
        Layout : Layout
    };
}); 