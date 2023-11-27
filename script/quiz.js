const questions = [
    {
        question: "Quel est le nom du groupe musical dont font partie Les Musclés?",
        options: ["Les Inconnus", "Les Charlots", "Les Musclés", "Les Enfoirés"],
        correctAnswer: 2
    },
    {
        question: "Quel était le titre du générique de l'émission 'Club Dorothée' interprété par Les Musclés?",
        options: ["La Fête au Village", "La Fête à Tout le Monde", "La Fête au Palais", "La Fête au Clair de Lune"],
        correctAnswer: 1
    },
    {
        question: "Quel membre des Musclés était aussi le producteur de l'émission 'Club Dorothée'?",
        options: ["René Morizur", "Éric Bouad", "Bernard Minet", "René Morizur"],
        correctAnswer: 3
    },
    {
        question: "Dans quelle série télévisée française Les Musclés jouaient-ils le rôle de musiciens?",
        options: ["Hélène et les Garçons", "Salut les Musclés", "Premiers Baisers", "Les Filles d'à côté"],
        correctAnswer: 1
    },
    {
        question: "Quel est l'instrument de musique principal de Rémy Sarrazin, membre des Musclés?",
        options: ["Guitare", "Batterie", "Basse", "Clavier"],
        correctAnswer: 0
    },
    {
        question: "Quelle année 'Club Dorothée' a-t-il été diffusé pour la première fois à la télévision française?",
        options: ["1983", "1985", "1987", "1989"],
        correctAnswer: 1
    },
    {
        question: "Quelle émission de télévision a remplacé 'Club Dorothée' après son arrêt en 1997?",
        options: ["Télé-Junior", "Télévisator 2", "Télé-Ado", "Mangas"],
        correctAnswer: 3
    },
    {
        question: "Quel chanteur français a interprété la chanson 'Merguez Partie' avec Les Musclés?",
        options: ["Jean-Jacques Goldman", "Johnny Hallyday", "Serge Lama", "Michel Sardou"],
        correctAnswer: 0
    },
    {
        question: "Dans le groupe Les Musclés, quel membre portait le nom de 'Framboisier'?",
        options: ["Rémy Sarrazin", "René Morizur", "Éric Bouad", "Bernard Minet"],
        correctAnswer: 1
    },
    {
        question: "Quelle émission jeunesse a été diffusée juste avant 'Club Dorothée' sur TF1?",
        options: ["Dorothée et ses Amis", "Youpi ! L'école est finie", "Vitamine", "Salut les P'tits Loups"],
        correctAnswer: 2
    }
];

const questionElement = document.getElementById("question");
const optionsContainer = document.getElementById("options");

let currentQuestionIndex = 0;
let score = 0;

function startQuiz() {
    currentQuestionIndex = 0;
    score = 0;
    showQuestion(questions[currentQuestionIndex]);
}

function showQuestion(question) {
    questionElement.innerText = question.question;
    optionsContainer.innerHTML = "";
    question.options.forEach((option, index) => {
        const button = document.createElement("button");
        button.innerText = option;
        button.classList.add("option-btn");
        button.addEventListener("click", selectOption);
        optionsContainer.appendChild(button);
    });
}

function selectOption(e) {
    const selectedButton = e.target;
    const correct = questions[currentQuestionIndex].correctAnswer === Array.from(optionsContainer.children).indexOf(selectedButton);
    if (correct) {
        score++;
    }
    Array.from(optionsContainer.children).forEach(button => {
        button.classList.add("disabled");
        if (questions[currentQuestionIndex].correctAnswer === Array.from(optionsContainer.children).indexOf(button)) {
            button.classList.add("correct");
        } else {
            button.classList.add("incorrect");
        }
    });
}

function nextQuestion() {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        showQuestion(questions[currentQuestionIndex]);
        Array.from(optionsContainer.children).forEach(button => {
            button.classList.remove("disabled", "correct", "incorrect");
        });
    } else {
        endQuiz();
    }
}

function endQuiz() {
    questionElement.innerText = `Votre score : ${score} sur ${questions.length}`;
    optionsContainer.innerHTML = "";
    questionElement.style.marginBottom = "0";
    optionsContainer.style.marginBottom = "0";
}

function selectOption(e) {
    const selectedButton = e.target;
    const correct = questions[currentQuestionIndex].correctAnswer === Array.from(optionsContainer.children).indexOf(selectedButton);
    if (correct) {
        score++;
    }
    Array.from(optionsContainer.children).forEach(button => {
        button.classList.add("disabled");
        if (questions[currentQuestionIndex].correctAnswer === Array.from(optionsContainer.children).indexOf(button)) {
            button.classList.add("correct");
        } else {
            button.classList.add("incorrect");
        }
    });
    nextQuestion();
}

startQuiz();