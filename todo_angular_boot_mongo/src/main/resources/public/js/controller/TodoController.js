angular.module('application', []).controller('TodoController', function ($scope, $http) {

    this.save = function () {
        $http.post('/todo', $scope.todo).success(function (data) {
            console.log("saved!");
        });
        $scope.todo = '';
        this.listAll();
    }

    
    this.doEditTodo  = function editTodo(id) {
    	$scope.todo = '';
    	for(var i=0; i< $scope.todos.length ;i++)
    		{
    		 if($scope.todos[i].id === id)
    			 {
    			    $scope.todo = $scope.todos[i];
    			    break;
    			 }
    		}
    }
   
    this.doDeleteTodo = function deleteTodo(id) {
        return $http({
            method : 'DELETE',
            url : '/todo/'+id 
            
        })
        
    }

    this.listAll = function () {
        this.todos = $http.get('/todo').success(function (data) {
            $scope.todos = data;
        });
    }

    this.listAll();


});