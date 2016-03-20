(function() {

    var app = angular.module("indexViewer", ["ngRoute", "ngCookies"]);

    app.config(function($routeProvider) {
      $routeProvider
        .when("/products", {
            templateUrl: "assets/views/products.html",
            controller: "ProductsController"
        })
        .when("/product", {
            templateUrl: "assets/views/product.html",
            controller: "ProductController"
        })
        .when("/checkout", {
              templateUrl: "assets/views/checkout.html",
              controller: "CheckoutController"
        })
        .when("/confirmCheckout", {
              templateUrl: "assets/views/thanks.html"
        })
        .otherwise({redirectTo:"/products"});

    })

}());