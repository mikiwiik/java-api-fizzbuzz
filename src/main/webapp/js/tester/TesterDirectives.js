'use strict';

function TesterForm() {
    return {
        restrict: 'E',
        replace: true,
        controller: 'ResultCtrl',
        controllerAs: 'vm',
        template: [
            '<form name="testerForm" ng-submit="vm.testNumber(vm.number)">',
            '   <div class="input-group">',
            '       <input type="text" required pattern="-?[0-9]+"',
            '           class="form-control" placeholder="Integer to test" ng-model="vm.number"/>',
            '    <span class="input-group-btn">',
            '        <button type="submit" class="btn btn-success">Submit</button>',
            '    </span>',
            '  </div>',
            '</form>'
        ].join('')
    }
}

angular.module('fizzbuzz-tester.directives', [])
    .directive('testerForm', TesterForm);
