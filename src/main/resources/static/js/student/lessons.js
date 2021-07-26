var lessonApi = Vue.resource('/student/lessons');

Vue.component('lesson-row',{
    props: ['lesson'],
    template: '<tr><td>{{ lesson.id }}</td>'+
        '<td>{{ lesson.theme }}</td>' +
        '<td>{{ new Date(lesson.lesDate).toLocaleDateString() }}</td>' +
        '<td>{{ lesson.file }}</td>' +
        '<td><form method="get" action="/test"  align="center">\n' +
        '    <button type="submit">Пройти тест</button>\n' +
        '</form></td></tr>'
});

Vue.component('lessons-list', {
    props: ['lessons'],
    template: '<div><table><tr><td>ID</td><td>Тема</td><td>Дата</td><td>Ссылка</td><td>Вопросы</td></tr>' +
        '<lesson-row v-for="lesson in lessons" :key="lesson.id" :lesson="lesson" /></table></div>',
    created: function (){
        lessonApi.get().then(result =>
            result.json().then(data =>
                data.forEach(lesson => this.lessons.push(lesson))
            )
        )
    }
});

var tableLessons = new Vue({
    el: '#table-lessons',
    template: '<lessons-list :lessons="lessons" />',
    data: {
        lessons: []
    }
});
