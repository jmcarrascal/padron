function DashboardController($scope, $rootScope, $http, $routeParams, I18nFactory, $templateCache) {
	$rootScope.module = "dashboard";
   	$rootScope.i18n = I18nFactory.getLanguage({ lang: $rootScope.defaultLanguage.abrev, module: $rootScope.module });	
   	
	$("#idViajes").hide();
	$("#idBtnAceptar").hide();
	
	$http({
        method: 'POST',
        url: $rootScope.baseUrl + '/rest/isValid'
        	                
    }).success(function (result) {
    	
    }).error(function (result, status) {
    	
    });
   	
   	

//   	$('.dropdown-menu li').each(function(){
//					var $this = $(this);
//					if($this.children('ul').length) {
//						$this.addClass('sub-dropdown');
//						$this.children('ul').addClass('sub-menu');
//					}
//				});
//				
//				$('.sub-dropdown').on('mouseenter',function(){
//					$(this).addClass('active').children('ul').addClass('sub-open');
//				}).on('mouseleave', function() {
//					$(this).removeClass('active').children('ul').removeClass('sub-open');
//				});	 
				
								
				 var data = [
				              ["", "", ""]
				            ];

				            $('#example').handsontable({
				              data: data,
				              minSpareRows: 1,
				              colHeaders: true,
				              contextMenu: true, 
				              rowHeaders: true,
				              nativeScrollbars: true
				            });
				   
				            
				            $scope.exportar = function() {
								
				        	var handsontable = $('#example').data('handsontable');
				        	
				        	$http({
				                method: 'POST',
				                url: $rootScope.baseUrl + '/rest/importPadron',
				                headers : {'Content-Type': 'application/json'},
				                data: {"data":handsontable.getData()}				                
				            }).success(function (result) {
				            	
				            	alert(result.result);
				            	
				            }).error(function (result, status) {
				            	
				            });

			
				            }
				
				
				
}


										