(function (angular) {
    'use strict';

    angular.module('fizzbuzz-results', [
        'fizzbuzz-results.controllers'
    ])
        .directive('latestresults', function () {
            return {
                restrict: 'E',
                replace: true,
                controller: 'StompCtrl',
                controllerAs: 'vm',
                templateUrl: '/js/latestResults.tpl.html'
            }
        });

}(angular));