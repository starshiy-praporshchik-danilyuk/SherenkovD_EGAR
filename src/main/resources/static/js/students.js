var studentsApi = Vue.resource('/teacher/students');

Vue.component('student-row', {
    props: ['student'],
    template: '<tr><td>{{ student.login }}</td>'+
        '<td>{{ student.name }}</td>' +
        '<td>{{ student.surname }}</td></tr>'
});

Vue.component('students-list', {
    props: ['students'],
    template: '<div><table><tr><td>Логин</td><td>Имя</td><td>Фамилия</td></tr>' +
        '<student-row v-for="student in students" :student="student" /></table></div>',
    created: function (){
        studentsApi.get().then(result =>
            result.json().then(data =>
                data.forEach(student => this.students.push(student))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<students-list :students="students" />',
    data: {
        students: []
    }
});