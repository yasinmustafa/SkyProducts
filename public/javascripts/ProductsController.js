(function() {

    var app = angular.module("indexViewer");


    var ProductsController = function($scope, $location, $rootScope, $http, $cookies, sharedService) {
        /*
         * Randomly generate a customerId cookie between 1 and 10
         */
        $scope.setCookieIfNotSet = function(cookieVal) {
            if (cookieVal) {
                return false;
            }
            $cookies.put('customerId',Math.floor((Math.random() * 10) + 1));
        };


        $scope.checkout = function(ids) {
            $scope.user = ' Searched';
            $scope.ids = ids;
            sharedService.setProducts(ids);
            $location.path("/checkout")
        };

        $scope.getLocation = function(customerId) {
            $http.get("location/" + customerId)
                .success(function(data) {
                    $scope.location = data;
                    console.log($scope.location.id);
                    $scope.getProducts($scope.location.id);
                });
        };

        $scope.getProducts = function(locationId) {
            $http.get("products/" + locationId)
                .success(function(data) {
                    $scope.products = data;
                });
        };

        $scope.countChecked = function(){
            var count = 0;
            angular.forEach($scope.ids, function(value){
                if (value==true) count++;
            });

            return count;
        };

        $scope.ids = sharedService.getProducts();


        $scope.setCookieIfNotSet($cookies.get('customerId'));
        $scope.getLocation($cookies.get('customerId'));



    };

    app.controller("ProductsController", ProductsController);

}());