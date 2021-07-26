
var lessonApi = Vue.resource('/teacher/lessons');

Vue.component('lesson-form', {
    props: ['lessons'],
    date: function (){
        return{
            name: '',
            link: ''
        }
    },
    template:
        '<div>' +
            '<input type="text" v-model="name" />' +
            '<input type="text" v-model="link" />' +
            '<input type="button" value="Save" @click="save" />'+
        '</div>',
    methods: {
        save: function (){
            var lesson = {theme: this.name, link: this.link};
            lessonApi.save({}, lesson).then(result =>
                result.json().then(data => {
                    this.lessons.push(data);
                })
            )
        }
    }
});

Vue.component('lesson-row',{
    props: ['lesson'],
    template: '<tr><td>{{ lesson.id }}</td>'+
                  '<td>{{ lesson.theme }}</td>' +
                  /*'<td><a href="/lesson">Открыть</a></td>'+*/
                  '<td>{{ new Date(lesson.lesDate).toLocaleDateString() }}</td>' +
                  '<td>{{ lesson.file }}</td>' +
                  '<td><form method="get" action="/lesson"  align="center">\n' +
                  '    <button type="submit" >Вопросы</button>\n' +
                  '</form></td></tr>'
                  /*'<questions :lesson="{{lesson.id}}"></questions>'*/
});

Vue.component('lessons-list', {
    props: ['lessons'],
    template: '<div><table><tr><td>ID</td><td>Тема</td><td>Дата</td><td>Ссылка</td><td>Вопросы</td></tr>' +
        '<lesson-row v-for="lesson in lessons" :key="lesson.id" :lesson="lesson" /></table>' +
        '<lesson-form :lessons="lessons" /></div>',
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