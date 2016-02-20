(function (angular) {
    'use strict';

    angular.module('fizzbuzz-results.directives', [])
        .directive('latestresults', function () {
            return {
                restrict: 'E',
                replace: true,
                controller: 'StompCtrl',
                controllerAs: 'vm',
                templateUrl: '/js/results/latestResults.tpl.html'
            }
        });

}(angular));