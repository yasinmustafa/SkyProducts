(function() {

    var sharedService = function() {
        var savedData = {};

        var setProducts = function(data) {
            savedData = data;
        };

        var getProducts = function() {
            return savedData;
        };

        return {
            setProducts: setProducts,
            getProducts: getProducts
        };
    };
    var app = angular.module("indexViewer");
    app.factory("sharedService", sharedService);

}());