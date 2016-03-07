'use strict';

function RestApi($http, $log) {
    this.getNumber = function (numberToTest) {
        $log.debug("About to test " + numberToTest);
        return $http({
            method: 'GET',
            url: '/api/' + numberToTest
        });
    }
}

angular.module('fizzbuzz-tester.services', [])
    .service('restApi', ['$http', '$log', RestApi]);
