'use strict';

function LatestResults() {
    return {
        scope: {
            resultsHeading: '@'
        },
        restrict: 'E',
        replace: true,
        controller: 'ResultCtrl',
        controllerAs: 'vm',
        template: [
            '<div class="panel panel-default">',
            '  <div class="panel-heading">',
            '    <h3 id="results-heading" class="panel-title">{{resultsHeading}}</h3>',
            '  </div>',
            '  <div class="panel-body" ng-repeat="test in vm.tests">',
            '    <div>{{test.number}}:{{test.result}}</div>',
            '  </div>',
            '</div>'].join('')
    }
}
angular.module('fizzbuzz.directives', [])
    .directive('latestResults', LatestResults);
