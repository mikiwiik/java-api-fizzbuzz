'use strict';

function StompCtrl($log, $scope, $controller) {
    var vm = this;

    function connect() {
        var socket = new SockJS('/stomp');
        var stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            $log.debug('Opening SockJS connection: ' + frame);
            stompClient.subscribe('/numbers/new', function (response) {
                $log.debug("Received number: " + JSON.stringify(response));
                $scope.$apply(function () {
                    var body = JSON.parse(response.body);
                    vm.addResult(body.number, body.fizzBuzz);
                });
            });
        });
    }

    angular.extend(vm, $controller('BaseCtrl', {$scope: $scope}));
    connect();
}

angular.module('fizzbuzz-results.controllers', [])
    .controller('StompCtrl', StompCtrl);
