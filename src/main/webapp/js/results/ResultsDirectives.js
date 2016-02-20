(function (angular) {
    'use strict';

    function LatestResults() {
        return {
            restrict: 'E',
            replace: true,
            controller: 'StompCtrl',
            controllerAs: 'vm',
            templateUrl: '/js/results/latestResults.tpl.html'
        }
    }
    angular.module('fizzbuzz-results.directives', [])
        .directive('latestResults', LatestResults);

}(angular));