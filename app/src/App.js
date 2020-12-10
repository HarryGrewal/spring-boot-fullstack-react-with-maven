import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import HeaderComponent from './components/HeaderComponent';
import ScoreComponent from './components/ScoreComponent';
import SubmitComponent from "./components/SubmitComponent";

function App() {
    return (
        <div>
            <Router>
                <HeaderComponent/>
                <div className="container">
                    <Switch>
                        <Route path="/" exact component={SubmitComponent}></Route>
                        <Route path="/scores" component={ScoreComponent}/>
                    </Switch>
                </div>
            </Router>
        </div>
    );
}

export default App;
