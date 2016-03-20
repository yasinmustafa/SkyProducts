(function() {

    var app = angular.module("indexViewer");


    var CheckoutController = function($scope, $location, $rootScope, $http, $cookies, sharedService) {


        $scope.getProducts = function() {
            return sharedService.getProducts();
        };

        $scope.cancelCheckout = function() {
            $location.path("/cancelCheckout")
        };

        $scope.confirmCheckout = function() {
            $location.path("/confirmCheckout")
        };


        $scope.customerId = $cookies.get('customerId');
        $scope.ids = $scope.getProducts();


    };

    app.controller("CheckoutController", CheckoutController);

}());