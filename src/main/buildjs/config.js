({
	appDir: '../../src/main/webapp/pages/',
	baseUrl: 'app',
	mainConfigFile: '../../src/main/webapp/pages/app/main.js',
	preserveLicenseComments: false,
	paths : {
		requireLib : 'lib/require/require'
	},
	
//	name : '../app/main',	
	//include : 'requireLib',

	dir: '../../src/main/webapp/pages/relese',
	optimizeCss : 'standard',

	modules : [
		{
		 	name : 'main',
		 	include : ["requireLib", "knockout", "jquery", "router", "stringTemplateEngine", "core", "ko.datepicker", "ko.selectbox", "bootstrap-modal", "ko.validation"]
		 },
		{
			name : 'moduls/dashboard/start',
			exclude : ['../app/main']
		},
		{
			name : 'moduls/registration/start',
			exclude : ['../app/main']
		}
	]

		//out: '../../src/main/webapp/pages/app/all_js.min.js'
	//, optimize: "none"
})