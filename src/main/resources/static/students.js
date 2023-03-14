angular.module('app',[]).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8080/app/api/v1'

    $scope.loadStudents = function() {
        $http.get(contextPath + '/students')
            .then(function (response) {
                $scope.StudentList = response.data;
            });
    };


    $scope.deleteStudent = function (studentId) {
        $http.delete(contextPath + '/students/delete/' + studentId)
            .then (function (response) {
                $scope.loadStudents();
            });
    };

    $scope.addStudent = function () {
        $http.post(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.loadStudents();
});