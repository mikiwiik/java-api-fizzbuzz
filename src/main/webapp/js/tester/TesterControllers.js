'use strict';

function RestCtrl($http, $log, $scope, $controller) {
    var vm = this;

    function testNumber(numberToTest) {
        $log.debug("About to test " + numberToTest);
        $http({
            method: 'GET',
            url: '/api/' + numberToTest
        }).then(function (response) {
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
    .controller('RestCtrl', RestCtrl);
