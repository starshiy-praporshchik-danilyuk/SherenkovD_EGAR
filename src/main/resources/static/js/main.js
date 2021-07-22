
var lessonApi = Vue.resource('/teacher/lessons');

Vue.component('lesson-form', {
    props: ['lessons'],
    date: function (){
        return{
            theme: '',
            link: ''
        }
    },
    template:
        '<div>' +
            '<input type="text" v-model="theme" />' +
            '<input type="text" v-model="link" />' +
            '<input type="button" value="Save" @click="save" />'+
        '</div>',
    methods: {
        save: function (){
            var lesson = {theme: this.theme, link: this.link};
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
                  '<td>{{ lesson.file }}</td></tr>'
                  /*'<questions :lesson="{{lesson.id}}"></questions>'*/
});

Vue.component('lessons-list', {
    props: ['lessons'],
    template: '<div><table><tr><td>ID</td><td>Тема</td><td>Дата</td><td>Ссылка</td></tr>' +
        '<lesson-row v-for="lesson in lessons" :key="lesson.id" :lesson="lesson" /></table>' +
        '<lesson-form :lessons="lessons" />' +
        '<questions lesson="dfhdfghdfg"></questions></div>',
    created: function (){
        lessonApi.get().then(result =>
            result.json().then(data =>
                data.forEach(lesson => this.lessons.push(lesson))
            )
        )
    }
});

Vue.component('questions',{
    props: ['lesson'],
    template: '<div>{{lesson}}</div>'
})
new Vue ({
    el: "#app1",
    /*data: {
        qwerty: ''
    }*/
});

var app = new Vue({
    el: '#app',
    template: '<lessons-list :lessons="lessons" />',
    data: {
        lessons: []
    }
});

/*
var app1 = new Vue({
    el: '#app1',
    template: '<questions/>',
    data: {
        questions: []
    }
})*/
