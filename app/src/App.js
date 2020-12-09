import React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent';
import TaskComponent from './components/TaskComponent';
import ScoreComponent from './components/ScoreComponent';

function App() {
    return (
        <div>
            <Router>
                <HeaderComponent />
                <div className="container">
                    <Switch>
                        <Route path="/" exact component={TaskComponent}></Route>
                        <Route path="/scores" component={ScoreComponent} />
                    </Switch>
                </div>
            </Router>
        </div>
    );
}

export default App;
