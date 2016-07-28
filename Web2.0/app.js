var app = angular.module('myApp',['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
   $routeProvider.
   
   when('/login', {
      templateUrl: 'app/login/login.html'
   }).
  
   otherwise({
      redirectTo: '/login'
   })
   
}]);