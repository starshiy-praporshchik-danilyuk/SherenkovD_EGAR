var studentsApi = Vue.resource('/teacher/students');

Vue.component('student-row', {
    props: ['student'],
    template: '<tr><td>{{ student.login }}</td>'+
        '<td>{{ student.name }}</td>' +
        '<td>{{ student.surname }}</td>' +
        '<td><form method="get" action="/answers"  align="center">' +
        '       <button type="submit" >Ответы</button>' +
        '    </form></td></tr>'
});

Vue.component('students-list', {
    props: ['students'],
    template: '<div><table><tr><td>Логин</td><td>Имя</td><td>Фамилия</td></tr>' +
        '<student-row v-for="student in students" :student="student" />' +
        '<student-answers :login="user_name" :lesson_id="lesson_id"/></table></div>',
    created: function (){
        studentsApi.get().then(result =>
            result.json().then(data =>
                data.forEach(student => this.students.push(student))
            )
        )
    },
    data(){
        return {
            user_name: 'stud',
            lesson_id: '1'
        }
    }
});

Vue.component('student-answers', {
    props: ['login', 'lesson_id'],
    template: '<div>Студент: {{login}}   Лекция: {{lesson_id}}</div>',
    created: function (){
        this.$http.get('/teacher/answers/' + this.login + '/' + this.lesson_id).then(result =>
            console.log(result)
        )
    }
});

var tableStudents = new Vue({
    el: '#table-students',
    template: '<students-list :students="students" />',
    data: {
        students: []
    }
});