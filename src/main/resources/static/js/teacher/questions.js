var questionsApi = Vue.resource('/teacher/questions');

Vue.component('question-form', {
    props: ['questions'],
    date: function (){
        return{
            /*lesson: '',*/
            phrasing: ''
        }
    },
    template:
        '<div>' +
        '<input type="text" v-model="phrasing" />' +
        '<input type="button" value="Save" @click="save" />'+
        '</div>',
    methods: {
        save: function (){
            /*this.lesson=1;*/
            var theme = 1;
            var question = {lesson: theme, phrasing: this.phrasing};
            questionsApi.save({}, question).then(result =>
                result.json().then(data => {
                    this.questions.push(data);
                })
            )
        }
    }
});

Vue.component('questions-list', {
    props: ['questions'],
    template: '<div><h1>Вопросы</h1>' +
        /*'<question-row v-for="question in questions" :question="question" /></table>' +*/
        '<li v-for="question in questions">{{question.phrasing}}</li>' +
        '<question-form :questions="questions" /></div>',
    created: function (){
        this.$http.get('/teacher/questions/' + 1).then(result =>
            result.json().then(data =>
                data.forEach(question => this.questions.push(question))
            )
        )
    }
});

var tableQuestions = new Vue({
    el: '#table-questions',
    template: '<questions-list :questions="questions" />',
    data: {
        questions: []
    }
});