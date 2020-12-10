import axios from 'axios'

const TASKS_REST_GET_API_URL = 'http://localhost:8080/task/getAllTasks';
const TASKS_REST_POST_API_URL = 'http://localhost:8080/task/submitTask';

class SubmitService {

    getTasks() {
        return axios.get(TASKS_REST_GET_API_URL);
    }

    postTask(userDetail) {
        return axios.post(TASKS_REST_POST_API_URL, userDetail);
    }
}

export default new SubmitService();
