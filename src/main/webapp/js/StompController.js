(function (angular) {
    'use strict';

    function StompCtrl($log, $scope) {
        var vm = this;
        vm.tests = [ ];

        function addResult(number, fizzBuzz) {
            vm.tests.push({
                number: number,
                result: fizzBuzz
            });
        }

        function connect() {
            var socket = new SockJS('/stomp');
            var stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                $log.debug('Opening SockJS connection: ' + frame);
                stompClient.subscribe('/numbers/new', function (response) {
                    $log.debug("Received number: " + JSON.stringify(response));
                    $scope.$apply(function () {
                        var body = JSON.parse(response.body);
                        addResult(body.number, body.fizzBuzz);
                    });
                });
            });
        }

        connect();
    }

    angular.module('fizzbuzz-results.controllers', [])
        .controller('StompCtrl', StompCtrl);

}(angular));