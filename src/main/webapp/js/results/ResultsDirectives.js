'use strict';

function LatestResults() {
    return {
        scope: {
            resultsHeading: '@'
        },
        restrict: 'E',
        replace: true,
        controller: 'StompCtrl',
        controllerAs: 'vm',
        template: [
            '<div class="col-md-6 col-md-offset-3">',
            '  <div class="panel panel-default" style="margin-top: 20px">',
            '    <div class="panel-heading">',
            '      <h3 class="panel-title">{{resultsHeading}}</h3>',
            '    </div>',
            '    <div class="panel-body" ng-repeat="test in vm.tests">',
            '      <div>{{test.number}}:{{test.result}}</div>',
            '    </div>',
            '  </div>',
            '</div>']
    }
}
angular.module('fizzbuzz-results.directives', [])
    .directive('latestResults', LatestResults);
