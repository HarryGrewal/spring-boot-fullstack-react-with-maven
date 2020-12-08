import axios from 'axios'

const TASKS_REST_API_URL = 'http://localhost:8080/task/getAllTasks';

class SubmissionService {

    getTasks() {
        return axios.get(TASKS_REST_API_URL);
    }
}

export default new SubmissionService();
