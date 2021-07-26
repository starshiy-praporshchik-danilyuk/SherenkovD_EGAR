Vue.component('answer-row', {
    props: ['answer'],
    template: '<tr><td>{{ answer.phrasing }}</td></tr>'
});

Vue.component('answers-list', {
    props: ['answers'],
    template: '<div><table><tr><td>Ответы</td></tr>' +
        '<answer-row v-for="answer in answers" :answer="answer" /></table></div>',
    created: function (){
        this.$http.get('/teacher/answers/' + 'stud' + '/' + 1).then(result =>
            result.json().then(data =>
                data.forEach(answer => this.answers.push(answer))
            )
        )
    }
});

var tableAnswers = new Vue({
    el: '#table-answers',
    template: '<answers-list :answers="answers" />',
    data: {
        answers: []
    }
});