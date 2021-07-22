var questionsApi = Vue.resource('/teacher/questions/{id_lesson}');

Vue.component('question-row', {
    props: ['question'],
    template: '<tr><td>{{ question.phrasing }}</td></tr>'
});

Vue.component('questions-list', {
    props: ['questions'],
    template: '<div><table><tr><td>Вопросы</td></tr>' +
        '<question-row v-for="question in questions" :question="question" /></table>',
    created: function (){
        questionsApi.get('1').then(result =>
            result.json().then(data =>
                data.forEach(question => this.questions.push(question))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<questions-list :questions="questions" />',
    data: {
        questions: []
    }
});