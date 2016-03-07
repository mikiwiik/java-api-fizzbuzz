'use strict';

function TesterController(restApi, $scope, $controller) {
    var vm = this;

    function testNumber(numberToTest) {
        restApi.getNumber(numberToTest)
            .then(function (response) {
                $log.debug("Handling result " + JSON.stringify(response));
                vm.addResult(numberToTest, response.data);
                // Clear the form
                vm.number = null;
                $scope.testerForm.$setPristine(true);
            });
    }

    vm.testNumber = testNumber;
    angular.extend(vm, $controller('BaseCtrl', {$scope: $scope}));
}

angular.module('fizzbuzz-tester.controllers', [])
    .controller('ResultCtrl', ['restApi', '$scope', '$controller', TesterController]);
