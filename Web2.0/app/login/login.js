angular.module("myApp").
controller("loginController",['$scope','message','$http',function($scope,message,$http){
	$scope.patientdata = [];
	$http.get("http://localhost:8080/J/patientFeed").success(function(resp){
		
		$scope.patientdata = resp;
	})
	$scope.message= message.myFunc("manish");
}]);