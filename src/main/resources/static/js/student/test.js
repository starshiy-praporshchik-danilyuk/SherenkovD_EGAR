var answersApi = Vue.resource('/student/answers');

Vue.component('question-row', {
    props: ['question'],
    date: function (){
        return {
            phrasing: ''
        }
    },
    template: '<tr><td>{{ question.phrasing }}</td>' +
        '<td><input type="text" v-model="phrasing" /></td>' +
        '<td><input type="button" value="Save" @click="save" /></td></tr>',
    methods: {
        save: function () {
            var answer = {question: '1', phrasing: this.phrasing};
            answersApi.save({}, answer);
        }
    }
});

Vue.component('questions-list', {
    props: ['questions'],
    template: '<div><table><tr><td>Вопросы</td><td>Ответ</td><td>Сохранить</td></tr>' +
        '<question-row v-for="question in questions" :question="question" /></table></div>',
    created: function (){
        this.$http.get('/student/questions/1').then(result =>
            result.json().then(data =>
                data.forEach(question => this.questions.push(question))
            )
        )
    }
});

var tableTest = new Vue({
    el: '#table-test',
    template: '<questions-list :questions="questions" />',
    data: {
        questions: []
    }
});