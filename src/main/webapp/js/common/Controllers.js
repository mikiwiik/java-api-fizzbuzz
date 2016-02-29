'use strict';

function BaseCtrl($log, $scope) {
    var vm = this;
    vm.tests = [ ];

    function addResult(number, fizzBuzz) {
        vm.tests.push({
            number: number,
            result: fizzBuzz
        });
    }

    vm.addResult = addResult;
}

angular.module('fizzbuzz.controllers', [])
    .controller('BaseCtrl', BaseCtrl);
