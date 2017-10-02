angular.module('application', []).controller('EmployeeController', function ($scope, $http) {

    this.save = function () {
        $http.post('/employee', $scope.employee).success(function (data) {
            console.log("saved!");
        });
        $scope.employee = '';
        this.listAll();
    }

    
    this.doEditUser  = function editUser(id) {
    	$scope.employee = '';
    	for(var i=0; i< $scope.employees.length ;i++)
    		{
    		 if($scope.employees[i].id === id)
    			 {
    			    $scope.employee = $scope.employees[i];
    			    break;
    			 }
    		}
    }
   
    this.doDeleteUser = function deleteUser(id) {
        return $http({
            method : 'DELETE',
            url : '/employee/'+id 
            
        })
        
    }

    this.listAll = function () {
        this.employees = $http.get('/employee').success(function (data) {
            $scope.employees = data;
        });
    }

    this.listAll();


});