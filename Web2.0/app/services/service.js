
angular.module('myApp').service('message', function() {
    this.myFunc = function (msg) {
        return "Hey " + msg ;
    }
});