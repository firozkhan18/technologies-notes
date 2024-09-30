


What is the purpose of callback function as an argument of setState()?
The callback function is invoked when setState finished and the component gets rendered. Since setState() is asynchronous the callback function is used for any post action.

Note: It is recommended to use lifecycle method rather than this callback function.

setState({ name: "John" }, () =>
  console.log("The name has updated and component re-rendered")
);

The callback function in `setState()` serves a specific purpose in React: it allows you to perform actions after the state has been updated and the component has re-rendered. Here's a breakdown of its purpose and behavior:

### Purpose of the Callback Function in `setState()`

1. **Asynchronous Nature**: `setState()` is asynchronous, meaning that when you call it, the state update doesn't happen immediately. React batches state updates for performance reasons, especially in event handlers. This can make it challenging to perform actions that depend on the updated state immediately after calling `setState()`.

2. **Post-Update Actions**: The callback function provides a way to execute code right after the state has been updated and the component has re-rendered. This is useful for tasks like:
   - Triggering side effects (e.g., making an API call).
   - Logging the new state.
   - Performing animations or transitions.

### Example

In your example:

```javascript
setState({ name: "John" }, () =>
  console.log("The name has updated and component re-rendered")
);
```

- **What Happens**: When you call `setState()`, it schedules an update to the state. After React updates the state and re-renders the component, it invokes the callback function, which logs a message to the console.
  
- **When to Use**: This pattern is useful if you need to perform some action that depends on the new state. For instance, if you need to fetch additional data based on the updated state, the callback is a good place to do that.

### Best Practices

- **Lifecycle Methods**: While using the callback function in `setState()` is valid, it's often recommended to leverage lifecycle methods or hooks (like `useEffect` in functional components) for managing side effects. This can lead to cleaner and more maintainable code.
  
- **Avoid Overuse**: Relying heavily on the callback in `setState()` can lead to code that's harder to follow. If your logic becomes complex, consider refactoring to use hooks or component lifecycle methods.

In summary, the callback function in `setState()` is a handy way to handle post-update actions, but there are often more structured and maintainable approaches, especially with modern React practices.

Lifecycle methods are often preferred over callback functions for managing state and effects because they provide a clearer structure for when and how components update.

For example, in React, using lifecycle methods like `componentDidMount`, `componentDidUpdate`, and `componentWillUnmount` allows you to handle side effects at specific points in a component's life. This can make your code more readable and easier to debug.

In React, "prop," "state," and "ref" are three fundamental concepts that are crucial for managing data and behavior in components. Here’s a breakdown of each:

### 1. Props

- **Definition**: Short for "properties," props are used to pass data from a parent component to a child component. They are read-only and help make components reusable.
  
- **Usage**: Props allow you to customize child components. For example:
  ```javascript
  function ChildComponent({ name }) {
    return <div>Hello, {name}!</div>;
  }

  function ParentComponent() {
    return <ChildComponent name="Alice" />;
  }
  ```

### 2. State

- **Definition**: State is a built-in object that allows components to create and manage their own local data. Unlike props, state is mutable and can change over time.

- **Usage**: State is typically initialized in a component and can be updated using the `setState` method (or the `useState` hook in functional components). For example:
  ```javascript
  import React, { useState } from 'react';

  function Counter() {
    const [count, setCount] = useState(0);

    return (
      <div>
        <p>Count: {count}</p>
        <button onClick={() => setCount(count + 1)}>Increment</button>
      </div>
    );
  }
  ```

### 3. Ref

- **Definition**: Refs are used to access and interact with DOM elements directly or to hold onto mutable values that don’t trigger re-renders. They are primarily created using `React.createRef()` in class components or the `useRef` hook in functional components.

- **Usage**: Refs are useful for scenarios like focusing an input, measuring a DOM element's dimensions, or storing values that need to persist without causing re-renders. For example:
  ```javascript
  import React, { useRef } from 'react';

  function TextInput() {
    const inputRef = useRef(null);

    const focusInput = () => {
      if (inputRef.current) {
        inputRef.current.focus();
      }
    };

    return (
      <div>
        <input ref={inputRef} type="text" />
        <button onClick={focusInput}>Focus Input</button>
      </div>
    );
  }
  ```

### Summary

- **Props**: Data passed from parent to child components; read-only.
- **State**: Local data managed within a component; mutable and can change over time.
- **Refs**: References to DOM elements or mutable values; used for direct manipulation and persistence without causing re-renders.

Understanding these concepts is key to effectively managing data flow and component behavior in React applications. 

In React, there are primarily two types of components: **Class Components** and **Functional Components**. Additionally, with the introduction of hooks, functional components have become the preferred way to write components. Here’s a breakdown of these types and their uses:

### 1. Class Components

- **Definition**: Class components are ES6 classes that extend `React.Component`. They can manage their own state and lifecycle methods.
  
- **Usage**:
  - Suitable for components that require lifecycle methods (like `componentDidMount`, `componentDidUpdate`, etc.).
  - Often used in larger applications where complex logic is required.

- **Example**:
  ```javascript
  import React, { Component } from 'react';

  class Greeting extends Component {
    constructor(props) {
      super(props);
      this.state = { message: "Hello" };
    }

    componentDidMount() {
      // Logic to run after the component mounts
    }

    render() {
      return <h1>{this.state.message}, {this.props.name}!</h1>;
    }
  }
  ```

### 2. Functional Components

- **Definition**: Functional components are simple JavaScript functions that return JSX. They can accept props and, with hooks, manage state and lifecycle events.

- **Usage**:
  - Preferred for most new development due to their simplicity and the ability to use hooks.
  - Ideal for components that do not require extensive lifecycle management.

- **Example**:
  ```javascript
  import React, { useState } from 'react';

  function Greeting({ name }) {
    const [message] = useState("Hello");
    return <h1>{message}, {name}!</h1>;
  }
  ```

### 3. Pure Components

- **Definition**: Pure components are a type of class component that implements `shouldComponentUpdate()` with a shallow prop and state comparison.

- **Usage**: They are useful when you want to optimize performance by preventing unnecessary re-renders when props or state haven’t changed.

- **Example**:
  ```javascript
  import React, { PureComponent } from 'react';

  class Greeting extends PureComponent {
    render() {
      return <h1>Hello, {this.props.name}!</h1>;
    }
  }
  ```

### 4. Higher-Order Components (HOCs)

- **Definition**: HOCs are functions that take a component and return a new component, often used for code reuse, logic abstraction, or adding additional props.

- **Usage**: Useful for cross-cutting concerns like authentication, logging, or fetching data.

- **Example**:
  ```javascript
  function withLogging(WrappedComponent) {
    return class extends React.Component {
      componentDidMount() {
        console.log("Component mounted");
      }

      render() {
        return <WrappedComponent {...this.props} />;
      }
    };
  }
  ```

### 5. Functional Components with Hooks

- **Definition**: These are functional components that use React hooks (`useState`, `useEffect`, etc.) to manage state and side effects.

- **Usage**: Preferred in modern React applications for their simplicity and improved state management.

- **Example**:
  ```javascript
  import React, { useState, useEffect } from 'react';

  function Greeting({ name }) {
    const [message, setMessage] = useState("Hello");

    useEffect(() => {
      // Effect logic here
    }, []);

    return <h1>{message}, {name}!</h1>;
  }
  ```

### Summary

- **Class Components**: Useful for more complex logic and lifecycle methods.
- **Functional Components**: Simpler and preferred for most use cases; can use hooks.
- **Pure Components**: Optimize performance by preventing unnecessary re-renders.
- **Higher-Order Components**: For code reuse and logic abstraction.
- **Functional Components with Hooks**: Modern approach to manage state and side effects.

Understanding these different types of components helps you choose the right approach based on your specific use case and the complexity of your application. 


Lifecycle hooks (or lifecycle methods) in React are special functions that allow you to run code at specific points in a component's lifecycle. They are primarily associated with class components, but with the introduction of hooks in functional components, similar behavior can now be achieved in a more streamlined way. Here’s a breakdown of how lifecycle hooks work in both class and functional components.

### Class Component Lifecycle Methods

In class components, there are several key lifecycle methods:

1. **Mounting**: Called when a component is being inserted into the DOM.
   - **`constructor()`**: Initializes state and binds methods.
   - **`componentDidMount()`**: Invoked immediately after a component is mounted. Perfect for fetching data or setting up subscriptions.

2. **Updating**: Called when a component is being re-rendered due to changes in state or props.
   - **`shouldComponentUpdate(nextProps, nextState)`**: Determines whether the component should re-render.
   - **`componentDidUpdate(prevProps, prevState)`**: Invoked immediately after updating occurs. Good for responding to prop or state changes.

3. **Unmounting**: Called when a component is being removed from the DOM.
   - **`componentWillUnmount()`**: Invoked immediately before a component is unmounted. Use this for cleanup tasks like cancelling network requests or removing event listeners.

4. **Error Handling**:
   - **`componentDidCatch(error, info)`**: Invoked when an error occurs in a child component. Good for logging errors.

### Example of Class Component Lifecycle Methods
```javascript
import React, { Component } from 'react';

class MyComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { data: null };
  }

  componentDidMount() {
    // Fetch data after the component mounts
    fetch('/api/data')
      .then(response => response.json())
      .then(data => this.setState({ data }));
  }

  shouldComponentUpdate(nextProps, nextState) {
    // Prevent re-render if data hasn't changed
    return nextState.data !== this.state.data;
  }

  componentDidUpdate(prevProps, prevState) {
    // Do something when the component updates
    if (prevState.data !== this.state.data) {
      console.log('Data has changed');
    }
  }

  componentWillUnmount() {
    // Cleanup tasks
    console.log('Component will unmount');
  }

  render() {
    return <div>{this.state.data ? this.state.data : 'Loading...'}</div>;
  }
}
```

### Functional Components with Hooks

In functional components, React provides hooks that allow you to achieve similar lifecycle behavior:

1. **`useEffect`**: This hook lets you perform side effects in functional components. It combines the functionality of several lifecycle methods.
   - **Effect for mounting**: If you provide an empty dependency array (`[]`), the effect runs once after the initial render, similar to `componentDidMount`.
   - **Effect for updating**: If you specify dependencies, the effect runs whenever those dependencies change, similar to `componentDidUpdate`.
   - **Cleanup**: You can return a function from the effect, which acts like `componentWillUnmount`.

### Example of Functional Component with Hooks
```javascript
import React, { useState, useEffect } from 'react';

function MyComponent() {
  const [data, setData] = useState(null);

  useEffect(() => {
    // Fetch data when the component mounts
    fetch('/api/data')
      .then(response => response.json())
      .then(data => setData(data));

    // Cleanup function (like componentWillUnmount)
    return () => {
      console.log('Cleanup tasks');
    };
  }, []); // Empty array means this effect runs only once

  return <div>{data ? data : 'Loading...'}</div>;
}
```

### Summary

- **Lifecycle methods** in class components allow you to run code at specific points in a component's lifecycle (mounting, updating, unmounting).
- **Hooks** like `useEffect` in functional components provide a way to handle similar lifecycle behavior, making it easier to manage side effects and cleanup.
- Understanding these lifecycle hooks is crucial for effectively managing component behavior and optimizing performance in React applications. 


In React, data can flow from parent components to child components via props, and sometimes you need to pass data or trigger actions from child components back to parent components. Here’s how to implement parent-to-child and child-to-parent communication in both functional and class components.

### Parent to Child Rendering

**Parent to Child** communication is straightforward: the parent component passes props to the child component.

#### Functional Component Example

```javascript
import React from 'react';

function ChildComponent({ message }) {
  return <h1>{message}</h1>;
}

function ParentComponent() {
  return <ChildComponent message="Hello from Parent!" />;
}
```

#### Class Component Example

```javascript
import React, { Component } from 'react';

class ChildComponent extends Component {
  render() {
    return <h1>{this.props.message}</h1>;
  }
}

class ParentComponent extends Component {
  render() {
    return <ChildComponent message="Hello from Parent!" />;
  }
}
```

### Child to Parent Rendering

**Child to Parent** communication is usually achieved by passing a function from the parent to the child as a prop. The child can then call this function to send data back to the parent.

#### Functional Component Example

```javascript
import React, { useState } from 'react';

function ChildComponent({ onSendData }) {
  const handleClick = () => {
    onSendData("Data from Child");
  };

  return <button onClick={handleClick}>Send Data to Parent</button>;
}

function ParentComponent() {
  const [data, setData] = useState("");

  const handleData = (childData) => {
    setData(childData);
  };

  return (
    <div>
      <ChildComponent onSendData={handleData} />
      <h2>Received: {data}</h2>
    </div>
  );
}
```

#### Class Component Example

```javascript
import React, { Component } from 'react';

class ChildComponent extends Component {
  handleClick = () => {
    this.props.onSendData("Data from Child");
  };

  render() {
    return <button onClick={this.handleClick}>Send Data to Parent</button>;
  }
}

class ParentComponent extends Component {
  constructor(props) {
    super(props);
    this.state = { data: "" };
  }

  handleData = (childData) => {
    this.setState({ data: childData });
  };

  render() {
    return (
      <div>
        <ChildComponent onSendData={this.handleData} />
        <h2>Received: {this.state.data}</h2>
      </div>
    );
  }
}
```

### Summary

- **Parent to Child**:
  - Pass data as props.
  - Use the prop in the child component to render or utilize the data.

- **Child to Parent**:
  - Pass a function from the parent to the child as a prop.
  - The child calls this function with any data it wants to send back to the parent, usually in response to an event (like a button click).
  
This pattern of data flow is foundational in React, allowing you to build interactive applications where components can communicate effectively. 


In React, the concepts of **key** and **index** are often discussed in the context of rendering lists of components. They serve different purposes and have important implications for how React handles updates and rendering. Here’s a breakdown of their differences and purposes:

### Key

- **Definition**: A `key` is a unique identifier that React uses to keep track of elements in a list. It is a special string attribute that you should provide when creating lists of elements in React.

- **Purpose**:
  - **Uniqueness**: Keys help React identify which items have changed, been added, or removed, thus allowing it to efficiently update the UI.
  - **Performance**: By using keys, React can optimize rendering and minimize the number of re-renders required. This improves performance, especially in large lists.

- **Best Practices**:
  - Use unique values (like IDs) from your data as keys when possible.
  - Avoid using indices as keys unless the list is static and will not change, as this can lead to issues with component state.

- **Example**:
  ```javascript
  const items = ['Apple', 'Banana', 'Cherry'];
  
  const ItemList = () => (
    <ul>
      {items.map((item) => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  );
  ```

### Index

- **Definition**: An `index` is simply the position of an item in an array. When rendering lists, you might use the array index as a fallback key if no unique identifier is available.

- **Purpose**:
  - **Position**: Index represents the position of the item within the array.
  - **Fallback**: It can be used as a key if the items in the list do not have unique identifiers and the list is static.

- **Cautions**:
  - Using indices as keys can lead to problems when items are reordered, added, or removed. React may confuse elements because it relies on keys to determine what has changed.
  - If the list is dynamic (items can change), using indices can cause unexpected behavior, as the components may retain their state incorrectly.

- **Example**:
  ```javascript
  const items = ['Apple', 'Banana', 'Cherry'];
  
  const ItemList = () => (
    <ul>
      {items.map((item, index) => (
        <li key={index}>{item}</li> // Not recommended for dynamic lists
      ))}
    </ul>
  );
  ```

### Summary

- **Key**:
  - Unique identifier for list items.
  - Improves performance and ensures correct rendering.
  - Should ideally be a unique value from your data (e.g., IDs).

- **Index**:
  - Represents the item's position in the array.
  - Can be used as a fallback for keys but can lead to issues in dynamic lists.
  - Generally not recommended unless the list is static.

Using keys correctly is essential for maintaining the integrity of your component states and ensuring efficient updates in React applications. 

1	What is React?
2	What is the history behind React evolution?
3	What are the major features of React?
4	What is JSX?
5	What is the difference between Element and Component?
6	How to create components in React?
7	When to use a Class Component over a Function Component?
8	What are Pure Components?
9	What is state in React?
10	What are props in React?
11	What is the difference between state and props?
12	What is the difference between HTML and React event handling?
13	What are synthetic events in React?
14	What are inline conditional expressions?
15	What is "key" prop and what is the benefit of using it in arrays of elements?
16	What is Virtual DOM?
17	How Virtual DOM works?
18	What is the difference between Shadow DOM and Virtual DOM?
19	What is React Fiber?
20	What is the main goal of React Fiber?
21	What are controlled components?
22	What are uncontrolled components?
23	What is the difference between createElement and cloneElement?
24	What is Lifting State Up in React?
25	What are Higher-Order components?
26	What is children prop?
27	How to write comments in React?
28	What is reconciliation?
29	Does the lazy function support named exports?
30	Why React uses className over class attribute?
31	What are fragments?
32	Why fragments are better than container divs?
33	What are portals in React?
34	What are stateless components?
35	What are stateful components?
36	How to apply validation on props in React?
37	What are the advantages of React?
38	What are the limitations of React?
39	What are the recommended ways for static type checking?
40	What is the use of react-dom package?
41	What is ReactDOMServer?
42	How to use InnerHtml in React?
43	How to use styles in React?
44	How events are different in React?
45	What is the impact of indexes as keys?
46	How do you conditionally render components?
47	Why we need to be careful when spreading props on DOM elements??
48	How do you memoize a component?
49	How you implement Server-Side Rendering or SSR?
50	How to enable production mode in React?
51	Do Hooks replace render props and higher order components?
52	What is a switching component?
53	What are React Mixins?
54	What are the Pointer Events supported in React?
55	Why should component names start with capital letter?
56	Are custom DOM attributes supported in React v16?
57	How to loop inside JSX?
58	How do you access props in attribute quotes?
59	What is React PropType array with shape?
60	How to conditionally apply class attributes?
61	What is the difference between React and ReactDOM?
62	Why ReactDOM is separated from React?
63	How to use React label element?
64	How to combine multiple inline style objects?
65	How to re-render the view when the browser is resized?
66	How to pretty print JSON with React?
67	Why you can't update props in React?
68	How to focus an input element on page load?
69	How can we find the version of React at runtime in the browser?
70	How to add Google Analytics for react-router?
71	How do you apply vendor prefixes to inline styles in React?
72	How to import and export components using react and ES6?
73	What are the exceptions on React component naming?
74	Is it possible to use async/await in plain React?
75	What are the common folder structures for React?
76	What are the popular packages for animation?
77	What is the benefit of styles modules?
78	What are the popular React-specific linters?
React Router
79	What is React Router?
80	How React Router is different from history library?
81	What are the <Router> components of React Router v6?
82	What is the purpose of push and replace methods of history?
83	How do you programmatically navigate using React router v4?
84	How to get query parameters in React Router v4
85	Why you get "Router may have only one child element" warning?
86	How to pass params to history.push method in React Router v4?
87	How to implement default or NotFound page?
88	How to get history on React Router v4?
89	How to perform automatic redirect after login?
React Internationalization
90	What is React Intl?
91	What are the main features of React Intl?
92	What are the two ways of formatting in React Intl?
93	How to use FormattedMessage as placeholder using React Intl?
94	How to access current locale with React Intl
95	How to format date using React Intl?
React Testing
96	What is Shallow Renderer in React testing?
97	What is TestRenderer package in React?
98	What is the purpose of ReactTestUtils package?
99	What is Jest?
100	What are the advantages of Jest over Jasmine?
101	Give a simple example of Jest test case
React Redux
102	What is Flux?
103	What is Redux?
104	What are the core principles of Redux?
105	What are the downsides of Redux compared to Flux?
106	What is the difference between mapStateToProps() and mapDispatchToProps()?
107	Can I dispatch an action in reducer?
108	How to access Redux store outside a component?
109	What are the drawbacks of MVW pattern
110	Are there any similarities between Redux and RxJS?
111	How to reset state in Redux?
112	What is the difference between React context and React Redux?
113	Why are Redux state functions called reducers?
114	How to make AJAX request in Redux?
115	Should I keep all component's state in Redux store?
116	What is the proper way to access Redux store?
117	What is the difference between component and container in React Redux?
118	What is the purpose of the constants in Redux?
119	What are the different ways to write mapDispatchToProps()?
120	What is the use of the ownProps parameter in mapStateToProps() and mapDispatchToProps()?
121	How to structure Redux top level directories?
122	What is redux-saga?
123	What is the mental model of redux-saga?
124	What are the differences between call and put in redux-saga
125	What is Redux Thunk?
126	What are the differences between redux-saga and redux-thunk
127	What is Redux DevTools?
128	What are the features of Redux DevTools?
129	What are Redux selectors and Why use them?
130	What is Redux Form?
131	What are the main features of Redux Form?
132	How to add multiple middlewares to Redux?
133	How to set initial state in Redux?
134	How Relay is different from Redux?
135	What is an action in Redux?
React Native
136	What is the difference between React Native and React?
137	How to test React Native apps?
138	How to do logging in React Native?
139	How to debug your React Native?
React supported libraries and Integration
140	What is reselect and how it works?
141	What is Flow?
142	What is the difference between Flow and PropTypes?
143	How to use font-awesome icons in React?
144	What is React Dev Tools?
145	Why is DevTools not loading in Chrome for local files?
146	How to use Polymer in React?
147	What are the advantages of React over Vue.js?
148	What is the difference between React and Angular?
149	Why React tab is not showing up in DevTools?
150	What are styled components?
151	Give an example of Styled Components?
152	What is Relay?
Miscellaneous
153	What are the main features of reselect library?
154	Give an example of reselect usage?
155	Can Redux only be used with React?
156	Do you need to have a particular build tool to use Redux?
157	How Redux Form initialValues get updated from state?
158	How React PropTypes allow different type for one prop?
159	Can I import an SVG file as react component?
160	What is render hijacking in React?
161	How to pass numbers to React component?
162	Do I need to keep all my state into Redux? Should I ever use react internal state?
163	What is the purpose of registerServiceWorker in React?
164	What is React memo function?
165	What is React lazy function?
166	How to prevent unnecessary updates using setState?
167	How do you render Array, Strings and Numbers in React 16 Version?
168	What are hooks?
169	What rules need to be followed for hooks?
170	How to ensure hooks followed the rules in your project?
171	What are the differences between Flux and Redux?
172	What are the benefits of React Router V4?
173	Can you describe about componentDidCatch lifecycle method signature?
174	In which scenarios do error boundaries not catch errors?
175	What is the behavior of uncaught errors in react 16?
176	What is the proper placement for error boundaries?
177	What is the benefit of component stack trace from error boundary?
178	What are default props?
179	What is the purpose of displayName class property?
180	What is the browser support for react applications?
181	What is code-splitting?
182	What are Keyed Fragments?
183	Does React support all HTML attributes?
184	When component props defaults to true?
185	What is NextJS and major features of it?
186	How do you pass an event handler to a component?
187	How to prevent a function from being called multiple times?
188	How JSX prevents Injection Attacks?
189	How do you update rendered elements?
190	How do you say that props are read only?
191	What are the conditions to safely use the index as a key?
192	Is it keys should be globally unique?
193	What is the popular choice for form handling?
194	What are the advantages of formik over redux form library?
195	Why do you not required to use inheritance?
196	Can I use web components in react application?
197	What is dynamic import?
198	What are loadable components?
199	What is suspense component?
200	What is route based code splitting?
201	What is the purpose of default value in context?
202	What is diffing algorithm?
203	What are the rules covered by diffing algorithm?
204	When do you need to use refs?
205	Is it prop must be named as render for render props?
206	What are the problems of using render props with pure components?
207	What is windowing technique?
208	How do you print falsy values in JSX?
209	What is the typical use case of portals?
210	How do you set default value for uncontrolled component?
211	What is your favorite React stack?
212	What is the difference between Real DOM and Virtual DOM?
213	How to add Bootstrap to a react application?
214	Can you list down top websites or applications using react as front end framework?
215	Is it recommended to use CSS In JS technique in React?
216	Do I need to rewrite all my class components with hooks?
217	How to fetch data with React Hooks?
218	Is Hooks cover all use cases for classes?
219	What is the stable release for hooks support?
220	Why do we use array destructuring (square brackets notation) in useState?
221	What are the sources used for introducing hooks?
222	How do you access imperative API of web components?
223	What is formik?
224	What are typical middleware choices for handling asynchronous calls in Redux?
225	Do browsers understand JSX code?
226	Describe about data flow in react?
227	What is MobX?
228	What are the differences between Redux and MobX?
229	Should I learn ES6 before learning ReactJS?
230	What is Concurrent Rendering?
231	What is the difference between async mode and concurrent mode?
232	Can I use javascript urls in react16.9?
233	What is the purpose of eslint plugin for hooks?
234	What is the difference between Imperative and Declarative in React?
235	What are the benefits of using typescript with reactjs?
236	How do you make sure that user remains authenticated on page refresh while using Context API State Management?
237	What are the benefits of new JSX transform?
238	How is the new JSX transform different from old transform?
239	What are React Server components?
240	What is prop drilling?
241	What is the difference between useState and useRef hook?
242	What is a wrapper component
243	What are the differences between useEffect and useLayoutEffect hooks
244	What are the differences between Functional and Class Components
245	What is strict mode in React?
246	What is the benefit of strict mode?
247	Why does strict mode render twice in React?
248	What are the rules of JSX?
249	What is the reason behind multiple JSX tags to be wrapped?
250	How do you prevent mutating array variables?
251	What are capture phase events?
252	How does React updates screen in an application?
253	How does React batch multiple state updates?
254	Is it possible to prevent automatic batching?
255	What is React hydration?
256	How do you update objects inside state?
257	How do you update nested objects inside state?
258	How do you update arrays inside state?
259	How do you use immer library for state updates?
260	What are the benefits of preventing the direct state mutations?
261	What are the preferred and non-preferred array operations for updating the state?
262	What will happen by defining nested function components?
263	Can I use keys for non-list items?
264	What are the guidelines to be followed for writing reducers?
265	What is useReducer hook? Can you describe its usage?
266	How do you compare useState and useReducer?
267	How does context works using useContext hook?
268	What are the use cases of useContext hook?
269	When to use client and server components?
270	What are the differences between page router and app router in nextjs?
Here’s a brief overview addressing each of your questions about React:

### 1. What is React?
React is a JavaScript library for building user interfaces, particularly for single-page applications. It allows developers to create reusable UI components that manage their own state.

### 2. What is the history behind React evolution?
React was developed by Facebook and released in 2013. It evolved from Facebook's need for a flexible and efficient way to build user interfaces, particularly for dynamic web applications. It introduced concepts like virtual DOM and component-based architecture, making UI development more efficient.

### 3. What are the major features of React?
- Component-based architecture
- Virtual DOM for efficient rendering
- JSX syntax for templating
- Unidirectional data flow
- Lifecycle methods for managing component state
- Hooks for functional components (introduced in React 16.8)

### 4. What is JSX?
JSX (JavaScript XML) is a syntax extension for JavaScript that looks similar to XML or HTML. It allows you to write HTML-like code within JavaScript, making it easier to create React elements.

### 5. What is the difference between Element and Component?
- **Element**: A plain object that describes a DOM node and its attributes. Elements are the building blocks of React applications.
- **Component**: A function or class that accepts props and returns React elements. Components can manage their own state and lifecycle.

### 6. How to create components in React?
Components can be created as:
- **Functional Components**: Functions that return JSX.
- **Class Components**: ES6 classes that extend `React.Component` and implement a `render` method.

### 7. When to use a Class Component over a Function Component?
Class components are used when you need to manage local component state or lifecycle methods. However, with the introduction of hooks, functional components can handle state and effects, making them more common in modern React development.

### 8. What are Pure Components?
Pure components are class components that implement `shouldComponentUpdate()` with a shallow prop and state comparison. They optimize performance by preventing unnecessary re-renders.

### 9. What is state in React?
State is a built-in object that allows components to create and manage their own local data. It can change over time, triggering a re-render of the component.

### 10. What are props in React?
Props (short for properties) are read-only attributes that are passed from a parent component to a child component, allowing data and event handlers to be shared.

### 11. What is the difference between state and props?
- **State**: Managed within the component; mutable and can change over time.
- **Props**: Passed from parent to child components; immutable within the child.

### 12. What is the difference between HTML and React event handling?
In React, events are named using camelCase, and you pass a function as the event handler. In HTML, events are written in lowercase and require the function to be referenced as a string.

### 13. What are synthetic events in React?
Synthetic events are a cross-browser wrapper around native events in React. They normalize the behavior of events to ensure consistent handling across different browsers.

### Synthetic Events in React

Synthetic events are React's way of normalizing browser events to provide a consistent interface across different browsers. They are wrappers around the native DOM events and follow the same API as the browser's native events, but they work consistently across all browsers.

When you handle an event in React, it is wrapped in a SyntheticEvent, which has the same properties and methods as the native event. This makes it easier to work with events without worrying about browser inconsistencies.

### Key Features of Synthetic Events:
1. **Normalization**: They ensure that the event properties behave consistently across all browsers.
2. **Pooling**: Synthetic events are pooled for performance reasons. This means that the event object will be reused, and properties will be nullified after the event handler is invoked, requiring you to access the properties within the event handler.

### Example Code

Here's a simple example demonstrating how to use Synthetic Events in a React component:

```jsx
import React, { useState } from 'react';

const SyntheticEventExample = () => {
  const [inputValue, setInputValue] = useState('');

  const handleChange = (event) => {
    // Accessing the value from the SyntheticEvent
    setInputValue(event.target.value);
  };

  const handleSubmit = (event) => {
    // Preventing the default form submission
    event.preventDefault();
    alert(`Submitted value: ${inputValue}`);
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <input 
          type="text" 
          value={inputValue} 
          onChange={handleChange} 
          placeholder="Type something..." 
        />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default SyntheticEventExample;
```

### Explanation of the Code

1. **Event Handling**: In the example above, we have two event handlers: `handleChange` and `handleSubmit`.
   - **`handleChange`**: This is called whenever the input value changes. The `event` parameter is a SyntheticEvent, which provides a normalized way to access `event.target.value`.
   - **`handleSubmit`**: This is called when the form is submitted. The default form submission behavior is prevented using `event.preventDefault()`, ensuring that the page doesn't reload.

2. **Form and Input**: The input field and the submit button are set up to call their respective handlers, demonstrating how SyntheticEvents manage user interactions.

### Benefits of Using Synthetic Events

- **Cross-Browser Compatibility**: You don’t have to worry about inconsistencies in how different browsers handle events.
- **Consistent API**: You can expect the same properties and methods from SyntheticEvents, making it easier to write cross-browser code.

In conclusion, Synthetic events in React provide a simplified and consistent way to handle events, making your code cleaner and more reliable across different browsers.

### Native Events in React

**Native events** are the standard events that are generated by the browser's Document Object Model (DOM) and are part of the standard JavaScript event system. These events are the same as those you would handle in plain JavaScript without React.

### Key Characteristics of Native Events:

1. **Browser-Dependent**: The behavior and properties of native events can vary across different browsers (e.g., Chrome, Firefox, Safari, etc.), which can lead to inconsistencies in event handling.

2. **Directly Attached to DOM Elements**: Native events are directly tied to HTML elements. When you attach an event listener to an element, you are working with the native event associated with that element.

3. **Event Properties**: Native events have a variety of properties and methods specific to the type of event (e.g., `event.target`, `event.currentTarget`, `event.preventDefault()`, etc.).

### Example of Using Native Events in React

Although React abstracts event handling through Synthetic Events, you can still interact with native events directly if needed. Here’s a simple example demonstrating native events:

```jsx
import React, { useRef } from 'react';

const NativeEventExample = () => {
  const inputRef = useRef(null);

  const handleFocus = () => {
    // Accessing the native input element directly
    inputRef.current.focus();
  };

  const handleClick = (event) => {
    // Accessing native event properties
    console.log('Native Event Type:', event.type);
    console.log('Clicked Element:', event.target);
  };

  return (
    <div>
      <input
        ref={inputRef}
        type="text"
        onClick={handleClick} // Using a native event
        placeholder="Click me to see the native event"
      />
      <button onClick={handleFocus}>Focus on Input</button>
    </div>
  );
};

export default NativeEventExample;
```

### Explanation of the Code

1. **Native Event Handling**: In the example, we define an `onClick` handler for the input field. When clicked, it logs properties of the native event to the console.

2. **Using Refs**: The `inputRef` is a reference to the input element, which allows us to directly access the DOM element and call the native `focus` method.

### Differences from Synthetic Events

- **Consistency**: Native events can behave differently across browsers, while React's Synthetic Events provide a consistent interface.
- **Pooling**: Native events do not use event pooling like Synthetic Events. Once a native event is triggered, it retains its properties for the duration of the event handler.

### Conclusion

While React primarily uses Synthetic Events for consistent and efficient event handling, understanding native events is essential, especially when you need to interact directly with the DOM or when performance is critical.

### 14. What are inline conditional expressions?
Inline conditional expressions are used in JSX to conditionally render elements. This is often done using the ternary operator or logical AND (`&&`) operator.

### 15. What is "key" prop and what is the benefit of using it in arrays of elements?
The `key` prop is a unique identifier for elements in a list. It helps React identify which items have changed, are added, or removed, improving performance and avoiding unnecessary re-renders.

### 16. What is Virtual DOM?
The Virtual DOM is an in-memory representation of the actual DOM. React uses it to optimize updates by calculating changes and only updating the parts of the DOM that have changed.

### 17. How Virtual DOM works?
When state or props change, React creates a new Virtual DOM. It compares this new Virtual DOM with the previous one (using a diffing algorithm) to determine what has changed, then efficiently updates the actual DOM.

### 18. What is the difference between Shadow DOM and Virtual DOM?
- **Shadow DOM**: A browser feature that encapsulates styles and markup in a component, preventing outside styles from affecting it.
- **Virtual DOM**: A concept used by React to optimize rendering and updates in the UI without directly manipulating the actual DOM.

### 19. What is React Fiber?
React Fiber is the reconciliation engine in React 16, designed to enable incremental rendering and improve the performance of complex applications.

### 20. What is the main goal of React Fiber?
The main goal of React Fiber is to enable smoother updates and better prioritization of tasks, allowing React to handle complex UIs and animations more efficiently.

### 21. What are controlled components?
Controlled components are form elements whose value is controlled by React state. The component renders the value from the state, and any changes are handled through event handlers.

### 22. What are uncontrolled components?
Uncontrolled components store their own state internally and rely on the DOM to handle updates. You can access their values through refs instead of state.

### 23. What is the difference between createElement and cloneElement?
- **`createElement`**: A function used to create React elements programmatically.
- **`cloneElement`**: A function used to clone an existing element and pass additional props to it.

### 24. What is Lifting State Up in React?
Lifting state up is a pattern where state is moved to a common ancestor component to allow multiple child components to share and synchronize the state.

### 25. What are Higher-Order components?
Higher-Order Components (HOCs) are functions that take a component and return a new component, often used for reusing component logic or adding additional behavior.

### 26. What is children prop?
The `children` prop is a special prop in React that allows you to pass components or elements as children to a parent component.

### 27. How to write comments in React?
Comments in JSX can be written using curly braces: `{/* Comment here */}`. In JavaScript, standard `//` or `/* ... */` comments can be used.

### 28. What is reconciliation?
Reconciliation is the process through which React updates the DOM by comparing the new Virtual DOM with the previous one and determining which changes need to be made.

### 29. Does the lazy function support named exports?
No, the `React.lazy()` function only supports default exports. You cannot use named exports directly with `React.lazy()`.

### 30. Why React uses className over class attribute?
React uses `className` instead of `class` because `class` is a reserved keyword in JavaScript. `className` serves the same purpose in JSX.

### 31. What are fragments?
Fragments are a way to group multiple elements without adding extra nodes to the DOM. They can be created using `<React.Fragment>` or the shorthand syntax `<>...</>`.

### 32. Why fragments are better than container divs?
Fragments prevent unnecessary nodes in the DOM, which can help reduce the complexity of the DOM tree and improve performance.

### 33. What are portals in React?
Portals allow you to render children into a DOM node that exists outside the hierarchy of the parent component. This is useful for modals and tooltips.

### 34. What are stateless components?
Stateless components are components that do not manage their own state and are primarily focused on rendering UI based on props.

### 35. What are stateful components?
Stateful components are components that manage their own state and can change their output based on user interactions or other events.

### 36. How to apply validation on props in React?
Prop validation can be done using the `prop-types` library, which allows you to specify the types and requirements for props passed to a component.

### 37. What are the advantages of React?
- Reusable components
- Virtual DOM for efficient rendering
- Strong community support
- Easy to learn and integrate
- Declarative UI development

### 38. What are the limitations of React?
- Requires additional libraries for state management (e.g., Redux)
- Not a full-fledged framework; may require more configuration
- Steeper learning curve for advanced concepts

### 39. What are the recommended ways for static type checking?
Using TypeScript or Flow for static type checking in React applications helps catch type-related errors during development.

### 40. What is the use of react-dom package?
The `react-dom` package provides DOM-specific methods for managing the rendering of React components to the DOM, such as `ReactDOM.render()`.

### 41. What is ReactDOMServer?
`ReactDOMServer` is a package used for server-side rendering (SSR) of React components, enabling the generation of HTML on the server.

### 42. How to use InnerHtml in React?
You can use `dangerouslySetInnerHTML` to set HTML directly in a component, but it should be used with caution to avoid XSS vulnerabilities.
```javascript
<div dangerouslySetInnerHTML={{ __html: '<p>Your HTML here</p>' }} />
```

### 43. How to use styles in React?
Styles can be applied in various ways, including:
- Inline styles using the `style` attribute.
- CSS stylesheets.
- CSS Modules for scoped styles.
- Styled-components for CSS-in-JS.

### 44. How events are different in React?
React normalizes events into synthetic events, which are consistent across browsers. Event names are camelCase, and you pass a function as the handler.

### 45. What is the impact of indexes as keys?
Using indices as keys can lead to issues with component state and rendering performance, especially in dynamic lists, as React may confuse elements when their order

 changes.

### 46. How do you conditionally render components?
You can use conditional statements or inline conditional expressions (like the ternary operator) in JSX to conditionally render components.

### 47. Why we need to be careful when spreading props on DOM elements?
When spreading props on DOM elements, you may inadvertently pass non-DOM attributes or functions, which can lead to unexpected behavior or warnings.

### 48. How do you memoize a component?
You can use `React.memo()` to memoize a functional component, preventing re-renders if the props haven't changed.
```javascript
const MemoizedComponent = React.memo(MyComponent);
```

### 49. How you implement Server-Side Rendering or SSR?
Server-side rendering can be implemented using `ReactDOMServer` to render components to HTML on the server, which is then sent to the client for faster initial load.

### 50. How to enable production mode in React?
To enable production mode, set the `NODE_ENV` environment variable to `production` before building your application. This can typically be done with commands like `npm run build`.

Here’s a comprehensive overview addressing each of your questions about React, React Router, React Internationalization, and React Testing:

### General React Questions

#### 51. Do Hooks replace render props and higher order components?
Yes, Hooks provide a more straightforward way to share logic between components, often replacing the need for render props and higher-order components (HOCs). They allow for cleaner and more readable component code.

#### 52. What is a switching component?
A switching component typically refers to a component that can toggle between different views or states based on user interaction, often implemented with state management.

#### 53. What are React Mixins?
Mixins were a way to reuse code in React components before Hooks were introduced. They allow components to share functionality. However, mixins are deprecated and not recommended in modern React.

#### 54. What are the Pointer Events supported in React?
React supports all standard pointer events, including `pointerdown`, `pointerup`, `pointermove`, `pointerenter`, `pointerleave`, `pointerover`, and `pointerout`.

#### 55. Why should component names start with a capital letter?
Component names should start with a capital letter to differentiate them from regular HTML elements. React treats lowercase names as built-in components (like `div`), while capitalized names are treated as user-defined components.

#### 56. Are custom DOM attributes supported in React v16?
Yes, React supports custom DOM attributes, but they should be prefixed with `data-` to avoid warnings and ensure proper behavior (e.g., `data-custom-attribute`).

#### 57. How to loop inside JSX?
You can use the `map()` method to loop over an array and return JSX elements.
```javascript
{array.map(item => <Component key={item.id} prop={item} />)}
```

#### 58. How do you access props in attribute quotes?
You can access props in JSX by using curly braces. For example:
```javascript
<Component someProp={props.someProp} />
```

#### 59. What is React PropType array with shape?
PropTypes can define the shape of an object within an array using `PropTypes.arrayOf()` along with `PropTypes.shape()`. This is used for validating complex prop structures.
```javascript
MyComponent.propTypes = {
  items: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
    })
  ).isRequired,
};
```

#### 60. How to conditionally apply class attributes?
You can conditionally apply classes using template literals or libraries like `classnames`.
```javascript
const className = isActive ? 'active' : 'inactive';
```

#### 61. What is the difference between React and ReactDOM?
React is the core library for building components, while ReactDOM provides methods for interacting with the DOM. ReactDOM is responsible for rendering components to the DOM.

#### 62. Why ReactDOM is separated from React?
Separating React and ReactDOM allows React to be more versatile and potentially used in different environments (like server-side rendering) without being tied to the DOM.

#### 63. How to use React label element?
In React, you can use the `<label>` element as you would in HTML. It can be associated with a form element using the `htmlFor` attribute:
```javascript
<label htmlFor="inputId">Label Text</label>
<input id="inputId" />
```

#### 64. How to combine multiple inline style objects?
You can combine multiple inline style objects using the spread operator.
```javascript
const combinedStyles = { ...style1, ...style2 };
```

#### 65. How to re-render the view when the browser is resized?
You can listen to the `resize` event and update the state accordingly, triggering a re-render.
```javascript
useEffect(() => {
  const handleResize = () => {
    setWindowSize(window.innerWidth);
  };
  window.addEventListener('resize', handleResize);
  return () => window.removeEventListener('resize', handleResize);
}, []);
```

#### 66. How to pretty print JSON with React?
You can use `JSON.stringify()` with formatting options inside a component to display JSON.
```javascript
<pre>{JSON.stringify(data, null, 2)}</pre>
```

#### 67. Why you can't update props in React?
Props are read-only in React. They are meant to be immutable, and the parent component is responsible for managing and passing props to child components.

#### 68. How to focus an input element on page load?
You can use the `useRef` hook to create a ref and call the `focus()` method when the component mounts.
```javascript
const inputRef = useRef(null);
useEffect(() => {
  inputRef.current.focus();
}, []);
return <input ref={inputRef} />;
```

#### 69. How can we find the version of React at runtime in the browser?
You can check the React version in the console using:
```javascript
console.log(React.version);
```

#### 70. How to add Google Analytics for react-router?
You can use the `useEffect` hook to send page views to Google Analytics whenever the route changes.
```javascript
import { useEffect } from 'react';
import { useLocation } from 'react-router-dom';

function Analytics() {
  const location = useLocation();
  useEffect(() => {
    window.gtag('config', 'GA_TRACKING_ID', {
      page_path: location.pathname,
    });
  }, [location]);
}
```

#### 71. How do you apply vendor prefixes to inline styles in React?
Vendor prefixes can be added manually or by using a CSS-in-JS solution like `styled-components` or `emotion`. Inline styles are defined using camelCase, so you would write:
```javascript
const style = { WebkitTransition: 'all 0.5s' };
```

#### 72. How to import and export components using react and ES6?
You can use `import` and `export` statements for components:
```javascript
// MyComponent.js
export const MyComponent = () => <div>Hello</div>;

// App.js
import { MyComponent } from './MyComponent';
```

#### 73. What are the exceptions on React component naming?
While component names should generally start with a capital letter, exceptions include the use of lowercase for components that don’t adhere to React's convention or for third-party libraries that require it.

#### 74. Is it possible to use async/await in plain React?
Yes, you can use async/await in React, particularly inside lifecycle methods or hooks like `useEffect`.
```javascript
useEffect(() => {
  const fetchData = async () => {
    const response = await fetch('/api/data');
    // handle response
  };
  fetchData();
}, []);
```

#### 75. What are the common folder structures for React?
Common folder structures might include:
```
/src
  /components
  /hooks
  /pages
  /services
  /styles
  /utils
```

#### 76. What are the popular packages for animation?
Popular animation libraries for React include:
- **Framer Motion**
- **React Spring**
- **React Transition Group**
- **GSAP**

#### 77. What is the benefit of styles modules?
CSS Modules provide scoped styles, preventing class name collisions and ensuring styles are applied only to the component they belong to.

#### 78. What are the popular React-specific linters?
Popular linters include:
- **ESLint** with `eslint-plugin-react`
- **Prettier** for code formatting
- **TSLint** for TypeScript projects

### React Router

#### 79. What is React Router?
React Router is a library for routing in React applications, allowing for navigation between different components and managing the browser history.

#### 80. How React Router is different from history library?
React Router provides a higher-level API for routing, managing the history of navigation, while the history library is a low-level API for managing session history in JavaScript applications.

#### 81. What are the <Router> components of React Router v6?
In React Router v6, key components include:
- **BrowserRouter**
- **HashRouter**
- **MemoryRouter**
- **Routes** and **Route** for defining routes.

#### 82. What is the purpose of push and replace methods of history?
- **push**: Adds a new entry to the history stack, allowing users to navigate back to it.
- **replace**: Replaces the current entry in the history stack, meaning users cannot navigate back to it.

#### 83. How do you programmatically navigate using React router v4?
You can use the `history` object, typically accessed via the `withRouter` higher-order component or the `useHistory` hook.
```javascript
const history = useHistory();
history.push('/new-route');
```

#### 84. How to get query parameters in React Router v4?
You can access query parameters using the `location` object from the props.
```javascript
const { search } = this.props.location;
const queryParams = new URLSearchParams(search);
const paramValue = queryParams.get('paramName');
```

#### 85. Why you get "Router may have only one child element" warning?
This warning occurs when a Router component (like `BrowserRouter`) has more than one direct child. You need to wrap multiple children in a single parent element.

#### 86. How to pass params to history.push method in React Router v4?
You can pass params as part of the path or as state.
```javascript
history.push(`/path/${paramValue}`);
```

#### 87. How to implement default or NotFound page?
You can define a route without a path at the end of your routes to

 catch all unmatched paths.
```javascript
<Route path="*" component={NotFound} />
```

#### 88. How to get history on React Router v4?
You can access the history object through the props passed to your component or by using the `useHistory` hook.
```javascript
const history = useHistory();
```

#### 89. How to perform automatic redirect after login?
You can use the `Redirect` component to navigate to a new route upon successful login.
```javascript
if (isLoggedIn) {
  return <Redirect to="/dashboard" />;
}
```

### React Internationalization

#### 90. What is React Intl?
React Intl is a library that provides internationalization (i18n) support for React applications, allowing developers to format dates, numbers, and strings in a locale-sensitive manner.

#### 91. What are the main features of React Intl?
Key features include:
- Formatting of strings, numbers, and dates
- Message translation
- Support for pluralization and gendered language

#### 92. What are the two ways of formatting in React Intl?
1. **Using the `FormattedMessage` component** for translating messages.
2. **Using the `intl` object** for formatting strings, numbers, and dates programmatically.

#### 93. How to use FormattedMessage as a placeholder using React Intl?
You can use the `FormattedMessage` component to create placeholders in your strings.
```javascript
<FormattedMessage id="app.greeting" values={{ name: "John" }} />
```

#### 94. How to access current locale with React Intl?
You can access the current locale via the `intl` object provided by the `injectIntl` higher-order component or the `useIntl` hook.
```javascript
const { locale } = useIntl();
```

#### 95. How to format date using React Intl?
You can use the `FormattedDate` component to format dates.
```javascript
<FormattedDate value={new Date()} year="numeric" month="long" day="numeric" />
```

### React Testing

#### 96. What is Shallow Renderer in React testing?
The Shallow Renderer is a utility that allows you to render a component without rendering its child components, making it easier to test individual components in isolation.

#### 97. What is TestRenderer package in React?
The TestRenderer package is used to render React components to pure JavaScript objects, allowing for assertions on the rendered output without interacting with the DOM.

#### 98. What is the purpose of ReactTestUtils package?
ReactTestUtils provides utility methods for testing React components, allowing you to simulate events, interact with component instances, and verify outputs.

#### 99. What is Jest?
Jest is a JavaScript testing framework developed by Facebook. It provides a complete testing solution, including test runners, assertion libraries, and mocking capabilities.

#### 100. What are the advantages of Jest over Jasmine?
- **Zero configuration**: Jest works out of the box without needing much setup.
- **Snapshot testing**: Jest supports snapshot testing for React components.
- **Mocking capabilities**: Built-in mocking functions make it easier to test complex components.
- **Parallel test execution**: Jest runs tests in parallel, speeding up the testing process.

Here's a comprehensive overview addressing your questions about Jest, React Redux, React Native, various libraries, and other React-related topics.

### Jest and Testing

#### 101. Give a simple example of a Jest test case.
```javascript
// sum.js
export const sum = (a, b) => a + b;

// sum.test.js
import { sum } from './sum';

test('adds 1 + 2 to equal 3', () => {
  expect(sum(1, 2)).toBe(3);
});
```

### React Redux

#### 102. What is Flux?
Flux is an application architecture for building client-side web applications. It emphasizes unidirectional data flow, allowing for better state management and easier debugging.

#### 103. What is Redux?
Redux is a predictable state container for JavaScript applications, primarily used with React. It manages the application state in a single store and uses actions to change the state.

#### 104. What are the core principles of Redux?
1. **Single source of truth**: The state of the entire application is stored in a single object.
2. **State is read-only**: The only way to change the state is by dispatching an action.
3. **Changes are made with pure functions**: Reducers are pure functions that take the previous state and an action to return the next state.

#### 105. What are the downsides of Redux compared to Flux?
- **Boilerplate code**: Redux often requires more boilerplate compared to Flux.
- **Complexity**: Redux can be more complex, especially for beginners, due to its strict structure.

#### 106. What is the difference between mapStateToProps() and mapDispatchToProps()?
- **mapStateToProps()**: Connects a part of the Redux state to the component's props.
- **mapDispatchToProps()**: Connects action creators to the component's props, allowing the component to dispatch actions.

#### 107. Can I dispatch an action in a reducer?
No, you should not dispatch actions in reducers. Reducers should be pure functions that only compute the next state based on the current state and the action received.

#### 108. How to access the Redux store outside a component?
You can use the `store.getState()` method to access the Redux store outside of components. However, avoid direct store access for state updates.

#### 109. What are the drawbacks of the MVW pattern?
- **Complexity**: Can become complex as the application grows.
- **Tight coupling**: The view and model can become tightly coupled, making it hard to manage.
- **Difficult to test**: Testing may become challenging if components are not well-separated.

#### 110. Are there any similarities between Redux and RxJS?
Both manage state and provide mechanisms for handling asynchronous events. They can be used together to create reactive applications.

#### 111. How to reset state in Redux?
You can reset the state by returning the initial state from the reducer when a specific action (like RESET) is dispatched.

#### 112. What is the difference between React context and React Redux?
React Context is used for passing data through the component tree without props drilling, while Redux is a state management library that provides a structured way to manage global application state.

#### 113. Why are Redux state functions called reducers?
Reducers are functions that take the previous state and an action as arguments and return the next state. The term "reducer" comes from the concept of reducing a collection of values down to a single value.

#### 114. How to make an AJAX request in Redux?
You can use middleware like Redux Thunk or Redux Saga to handle asynchronous requests and dispatch actions based on the request's success or failure.

#### 115. Should I keep all component's state in the Redux store?
Not necessarily. Local component state is suitable for UI-specific state, while Redux is best for global application state that needs to be shared across components.

#### 116. What is the proper way to access the Redux store?
Use the `useSelector` and `useDispatch` hooks (for functional components) or the `connect` function (for class components) to interact with the Redux store.

#### 117. What is the difference between component and container in React Redux?
- **Component**: Presentational components that receive data via props and focus on rendering UI.
- **Container**: Connected to the Redux store and often handle logic for fetching data and dispatching actions.

#### 118. What is the purpose of the constants in Redux?
Constants are used to define action types in Redux to avoid typos and make actions easier to manage.

#### 119. What are the different ways to write mapDispatchToProps()?
1. **Object shorthand**: Directly passing action creators.
2. **Function**: Defining a function that dispatches actions.

#### 120. What is the use of the ownProps parameter in mapStateToProps() and mapDispatchToProps()?
`ownProps` allows access to the component's props within `mapStateToProps` or `mapDispatchToProps`, enabling dynamic mapping based on the props.

#### 121. How to structure Redux top-level directories?
A common structure includes:
```
/src
  /actions
  /reducers
  /store
  /components
  /containers
```

#### 122. What is redux-saga?
Redux-Saga is a middleware library for managing side effects in Redux applications, providing a way to handle asynchronous actions using generator functions.

#### 123. What is the mental model of redux-saga?
Redux-Saga uses the concept of "sagas" to manage complex asynchronous flows, allowing developers to define side effects as generator functions that yield effects.

#### 124. What are the differences between call and put in redux-saga?
- **call**: Used to invoke functions, including async calls (e.g., API requests).
- **put**: Dispatches an action to the Redux store.

#### 125. What is Redux Thunk?
Redux Thunk is middleware that allows you to write action creators that return a function instead of an action. This function can perform asynchronous dispatches.

#### 126. What are the differences between redux-saga and redux-thunk?
- **Control flow**: Redux-Saga uses generator functions for better control flow, while Redux Thunk uses functions.
- **Testing**: Sagas can be more straightforward to test due to their generator-based nature.

#### 127. What is Redux DevTools?
Redux DevTools is a tool that allows developers to inspect and debug Redux state changes and actions.

#### 128. What are the features of Redux DevTools?
- Time-travel debugging
- Action logging
- State persistence
- Ability to export and import state

#### 129. What are Redux selectors and why use them?
Selectors are functions that extract specific pieces of state from the Redux store. They help encapsulate state logic and improve performance through memoization.

#### 130. What is Redux Form?
Redux Form is a library that integrates form handling with Redux, providing a way to manage form state in a Redux store.

#### 131. What are the main features of Redux Form?
- Manage form state in Redux
- Validation and error handling
- Support for complex forms and dynamic fields

#### 132. How to add multiple middlewares to Redux?
You can use the `applyMiddleware` function from Redux to add multiple middlewares.
```javascript
import { createStore, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';

const store = createStore(reducer, applyMiddleware(thunk, logger));
```

#### 133. How to set initial state in Redux?
Initial state is set in the reducer function as the default parameter.
```javascript
const initialState = { count: 0 };
const reducer = (state = initialState, action) => {
  // logic
};
```

#### 134. How Relay is different from Redux?
Relay is a framework for building data-driven React applications, emphasizing a GraphQL-based data-fetching layer. Redux is a state management library focused on managing application state.

#### 135. What is an action in Redux?
An action is a plain JavaScript object that describes a change in the application state, containing a `type` property and any additional data required to perform the update.

### React Native

#### 136. What is the difference between React Native and React?
React is a library for building web applications, while React Native is a framework for building mobile applications using native components.

#### 137. How to test React Native apps?
You can use testing libraries like Jest for unit tests and React Native Testing Library for component tests. For end-to-end testing, you can use tools like Detox or Appium.

#### 138. How to do logging in React Native?
You can use `console.log()` for basic logging or integrate libraries like `react-native-logger` for more advanced logging capabilities.

#### 139. How to debug your React Native?
Use the built-in Debugger in the React Native development tools, and tools like React DevTools and Flipper for more advanced debugging capabilities.

### React Supported Libraries and Integration

#### 140. What is reselect and how it works?
Reselect is a library for creating memoized selectors in Redux. It computes derived data from the Redux store, ensuring performance by memoizing results based on input selectors.

#### 141. What is Flow?
Flow is a static type checker for JavaScript developed by Facebook. It helps catch type-related errors in your code before runtime.

#### 142. What is the difference between Flow and PropTypes?
Flow provides static type checking at build time, while PropTypes offers runtime type checking for React component props.

#### 143. How to use font-awesome icons in React?
You can use the `react-fontawesome` library or include Font Awesome via a

 CDN in your project.
```javascript
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCoffee } from '@fortawesome/free-solid-svg-icons';

<FontAwesomeIcon icon={faCoffee} />;
```

#### 144. What is React Dev Tools?
React Dev Tools is a browser extension that provides a way to inspect React component hierarchies and their props and state.

#### 145. Why is DevTools not loading in Chrome for local files?
DevTools may not work with local files due to security restrictions. Serve your app through a local server (like `http-server`) instead.

#### 146. How to use Polymer in React?
You can use Polymer components within React by wrapping them in React components and managing their lifecycle methods appropriately.

#### 147. What are the advantages of React over Vue.js?
- **Popularity and community support**: React has a larger community and more third-party libraries.
- **Flexibility**: React offers more flexibility in architecture and state management options.
- **Performance**: React's virtual DOM is optimized for performance in larger applications.

#### 148. What is the difference between React and Angular?
React is a library focused on building UI components, while Angular is a full-fledged framework that includes everything needed to build a complete application, including routing, state management, and form handling.

#### 149. Why is the React tab not showing up in DevTools?
If the React tab doesn't show, ensure you have React DevTools installed and that you're running React in development mode.

#### 150. What are styled components?
Styled Components is a library for styling React components using tagged template literals, allowing for scoped styles and dynamic styling.

#### 151. Give an example of Styled Components.
```javascript
import styled from 'styled-components';

const Button = styled.button`
  background-color: blue;
  color: white;
  padding: 10px;
`;

<Button>Click Me</Button>
```

#### 152. What is Relay?
Relay is a JavaScript framework for building data-driven React applications with GraphQL, focusing on data-fetching and managing data dependencies.

### Miscellaneous

#### 153. What are the main features of the reselect library?
- Memoized selectors
- Composability of selectors
- Performance optimizations

#### 154. Give an example of reselect usage.
```javascript
import { createSelector } from 'reselect';

const getItems = (state) => state.items;
const getFilter = (state) => state.filter;

const getVisibleItems = createSelector(
  [getItems, getFilter],
  (items, filter) => items.filter(item => item.visible === filter)
);
```

#### 155. Can Redux only be used with React?
No, Redux can be used with any JavaScript framework or library, but it is most commonly associated with React due to its ecosystem.

#### 156. Do you need to have a particular build tool to use Redux?
No, Redux can be used with any JavaScript build tool. Common choices include Webpack, Parcel, and Create React App.

#### 157. How does Redux Form `initialValues` get updated from state?
You can pass the `initialValues` prop to the Redux Form component, and it will update when the Redux state changes.

#### 158. How do React PropTypes allow different types for one prop?
You can use the `oneOfType` validator to specify that a prop can be one of several types.
```javascript
MyComponent.propTypes = {
  myProp: PropTypes.oneOfType([PropTypes.string, PropTypes.number])
};
```

#### 159. Can I import an SVG file as a React component?
Yes, you can import SVG files as React components using a loader like `@svgr/webpack` in your build setup.
```javascript
import { ReactComponent as Logo } from './logo.svg';
<Logo />;
```

#### 160. What is render hijacking in React?
Render hijacking is a technique where a higher-order component or a render prop component alters the rendering behavior of its child components.

#### 161. How to pass numbers to a React component?
You can pass numbers just like any other prop, ensuring to define the prop type correctly.
```javascript
<MyComponent count={5} />
```

#### 162. Do I need to keep all my state in Redux? Should I ever use React internal state?
No, only global state shared across components should go in Redux. Local state specific to a single component is best managed with React's internal state.

#### 163. What is the purpose of `registerServiceWorker` in React?
`registerServiceWorker` is used to enable service workers for your application, allowing for offline capabilities and faster loading times.

#### 164. What is the React memo function?
`React.memo` is a higher-order component that memoizes functional components, preventing unnecessary re-renders when the props haven’t changed.

#### 165. What is the React lazy function?
`React.lazy` is a function that enables dynamic import of components, allowing for code-splitting and reducing the initial bundle size.

#### 166. How to prevent unnecessary updates using `setState`?
Use `shouldComponentUpdate` in class components or `React.memo` for functional components to control re-renders based on state or props changes.

#### 167. How do you render arrays, strings, and numbers in React 16?
You can directly render them within JSX. React 16 supports rendering arrays and fragments.
```javascript
const items = [<li key="1">Item 1</li>, <li key="2">Item 2</li>];
return <ul>{items}</ul>;
```

#### 168. What are hooks?
Hooks are functions that let you use state and lifecycle features in functional components, such as `useState`, `useEffect`, and custom hooks.

#### 169. What rules need to be followed for hooks?
1. Only call hooks at the top level of a function component.
2. Only call hooks from React function components or custom hooks.

#### 170. How to ensure hooks follow the rules in your project?
Use ESLint rules with the `eslint-plugin-react-hooks` plugin to enforce the rules of hooks.

#### 171. What are the differences between Flux and Redux?
- **Architecture**: Flux uses multiple stores, while Redux has a single store.
- **Data flow**: Redux uses a unidirectional flow with pure functions (reducers), whereas Flux relies on callbacks.

#### 172. What are the benefits of React Router V4?
- Declarative routing
- Route nesting
- Dynamic route matching

#### 173. Can you describe the `componentDidCatch` lifecycle method signature?
`componentDidCatch(error, info)` receives two arguments: the error that was thrown and an object containing information about the component that threw the error.

#### 174. In which scenarios do error boundaries not catch errors?
Error boundaries do not catch errors in event handlers, asynchronous code, server-side rendering, or errors thrown in the error boundary itself.

#### 175. What is the behavior of uncaught errors in React 16?
Uncaught errors in React 16 will result in the entire component tree being unmounted, while an error boundary can catch and handle them gracefully.

#### 176. What is the proper placement for error boundaries?
Error boundaries should wrap components that might throw errors, typically at a high level in your component tree.

#### 177. What is the benefit of the component stack trace from the error boundary?
It provides information about the component hierarchy and helps identify where an error originated, making debugging easier.

#### 178. What are default props?
Default props are values that a component uses if no props are provided by the parent component. They can be defined using `defaultProps`.
```javascript
MyComponent.defaultProps = {
  color: 'blue',
};
```

#### 179. What is the purpose of the `displayName` class property?
The `displayName` property is used to give a component a name for easier debugging in React DevTools.

#### 180. What is the browser support for React applications?
React applications are supported in modern browsers like Chrome, Firefox, Safari, and Edge. Internet Explorer 11 is also supported, but with limitations.

#### 181. What is code-splitting?
Code-splitting is a technique that allows you to split your code into smaller chunks, which can be loaded on demand, improving performance.

#### 182. What are Keyed Fragments?
Keyed Fragments allow you to assign a unique key to a fragment, enabling React to better optimize rendering and updates.

#### 183. Does React support all HTML attributes?
React supports most HTML attributes, but some are camelCased (e.g., `className` instead of `class`) and some are omitted for security reasons (e.g., `onLoad` for images).

#### 184. When do component props default to true?
Props that are boolean values can be defaulted to true when they are provided without a value in JSX, like `<MyComponent propName />`.

#### 185. What is Next.js and its major features?
Next.js is a React framework that enables server-side rendering and static site generation. Major features include:
- Automatic code-splitting
- File-system based routing
- API routes

#### 186. How do you pass an event handler to a component?
You can pass an event handler as a prop to a component.
```javascript
<MyComponent onClick={handleClick} />
```

#### 187. How to prevent a function from being called multiple times?
You can debounce or throttle the function using libraries like Lodash or implement your own logic to control how frequently the function can be invoked.

#### 188. How does JSX prevent injection attacks?
JSX escapes values interpolated within it, preventing the injection of malicious code and ensuring that user input is rendered as plain text.

#### 

189. How do you update rendered elements?
You can update rendered elements by changing the component's state or props, triggering a re-render.

#### 190. How do you say that props are read-only?
Props are read-only because they are immutable from the perspective of the child component; the child cannot modify them.

#### 191. What are the conditions to safely use the index as a key?
You can safely use the index as a key when:
- The list is static and does not change.
- The items do not have unique identifiers.

#### 192. Should keys be globally unique?
Keys should be unique among siblings but do not need to be globally unique across the application.

#### 193. What is the popular choice for form handling?
Formik and React Hook Form are popular libraries for managing forms in React applications.

#### 194. What are the advantages of Formik over Redux Form library?
- Simplicity and reduced boilerplate
- Better performance
- Easier integration with uncontrolled components

#### 195. Why do you not require to use inheritance?
React promotes composition over inheritance, allowing for more flexible and reusable component designs.

#### 196. Can I use web components in a React application?
Yes, you can use web components in React applications, although you may need to handle their lifecycle methods appropriately.

#### 197. What is dynamic import?
Dynamic import allows you to load JavaScript modules on demand, improving performance and enabling code-splitting.

#### 198. What are loadable components?
Loadable components are a way to dynamically load components in React, optimizing bundle size and improving initial load times.

#### 199. What is the suspense component?
Suspense is a feature that allows you to wait for some code to load and declaratively specify a loading state for components.

#### 200. What is route-based code splitting?
Route-based code splitting involves splitting your application into separate bundles for different routes, allowing only the required code to load for each route, improving performance.
Here’s a concise breakdown of your questions about React and related topics:

### Context and Diffing Algorithm

**201. What is the purpose of default value in context?**
Default values in context provide a fallback when no provider is found in the component tree, ensuring that components can still function without explicit context values.

**202. What is the diffing algorithm?**
The diffing algorithm is the process React uses to compare the new virtual DOM with the previous one, determining what has changed so it can efficiently update the real DOM.

**203. What are the rules covered by diffing algorithm?**
1. **Element Type Comparison**: If the type of two elements is different, React will replace the old element with the new one.
2. **Key Prop**: Elements with the same key will be treated as the same component.
3. **Reconciliation**: React will recursively compare child elements to optimize updates.

### Refs, Render Props, and Windowing

**204. When do you need to use refs?**
Refs are used for accessing DOM elements directly or for storing mutable values that do not trigger re-renders when changed.

**205. Is the prop must be named as render for render props?**
While it's common to use the `render` prop name for render props, it's not mandatory. You can use any name as long as it's consistent.

**206. What are the problems of using render props with pure components?**
Using render props can lead to unnecessary re-renders in pure components, as changes in the render prop can cause the entire component to re-evaluate.

**207. What is windowing technique?**
Windowing is a technique used to render only a subset of large lists of items in the DOM, improving performance by reducing the number of elements rendered at once (e.g., using libraries like `react-window`).

### JSX and Portals

**208. How do you print falsy values in JSX?**
Falsy values (like `null` or `undefined`) will not render anything in JSX. If you want to display them, you can conditionally render a string or a placeholder.

**209. What is the typical use case of portals?**
Portals are typically used for rendering children into a DOM node that exists outside the hierarchy of the parent component, useful for modals, tooltips, or pop-ups.

### Controlled and Uncontrolled Components

**210. How do you set a default value for an uncontrolled component?**
You can set the default value using the `defaultValue` attribute on form elements like `<input>` or `<textarea>`.

### React Stack and DOM Concepts

**211. What is your favorite React stack?**
A popular React stack includes React, Redux for state management, React Router for routing, and libraries like Axios for HTTP requests.

**212. What is the difference between Real DOM and Virtual DOM?**
Real DOM is the actual representation of the UI, while Virtual DOM is a lightweight copy used by React to optimize updates by diffing changes before reflecting them in the Real DOM.

### Adding Bootstrap and Web Applications

**213. How to add Bootstrap to a React application?**
You can add Bootstrap by installing it via npm (`npm install bootstrap`) and importing it in your main JavaScript file or by including the Bootstrap CDN in your HTML file.

**214. Can you list down top websites or applications using React as a front-end framework?**
Some examples include Facebook, Instagram, Netflix, Airbnb, and WhatsApp Web.

### CSS and Hooks

**215. Is it recommended to use CSS-in-JS technique in React?**
It depends on the project and team preferences. CSS-in-JS provides benefits like scoped styles and dynamic styling but may introduce additional complexity.

**216. Do I need to rewrite all my class components with hooks?**
No, it’s not necessary. You can continue using class components, but hooks offer a more concise way to manage state and lifecycle methods.

### Fetching Data and Hooks

**217. How to fetch data with React Hooks?**
You can use the `useEffect` hook to fetch data within a functional component.
```javascript
useEffect(() => {
  const fetchData = async () => {
    const response = await fetch('/api/data');
    const result = await response.json();
    setData(result);
  };
  fetchData();
}, []);
```

**218. Do Hooks cover all use cases for classes?**
Hooks cover most use cases, but there are still some scenarios where class components may be more straightforward.

**219. What is the stable release for hooks support?**
Hooks were introduced in React 16.8.

### Array Destructuring and Sources

**220. Why do we use array destructuring (square brackets notation) in useState?**
Array destructuring allows easy access to state variables and their updater functions from the `useState` hook.
```javascript
const [count, setCount] = useState(0);
```

**221. What are the sources used for introducing hooks?**
Hooks were introduced to simplify state management and side effects in functional components, making them more powerful and expressive.

### Imperative APIs and Form Handling

**222. How do you access the imperative API of web components?**
You can access the imperative API by using refs to get a reference to the web component instance.

**223. What is Formik?**
Formik is a library for building forms in React, providing tools for managing form state, validation, and submission.

### Middleware and Browsers

**224. What are typical middleware choices for handling asynchronous calls in Redux?**
Common choices include Redux Thunk and Redux Saga.

**225. Do browsers understand JSX code?**
No, browsers do not understand JSX directly; it needs to be transpiled to regular JavaScript.

### Data Flow and State Management

**226. Describe data flow in React.**
Data flows unidirectionally in React, meaning data flows down from parent components to child components via props.

**227. What is MobX?**
MobX is a state management library that uses observable state and provides reactive programming capabilities.

**228. What are the differences between Redux and MobX?**
Redux emphasizes a single immutable state tree and strict unidirectional data flow, while MobX uses mutable observables and allows for more flexible state management.

### Learning Path and Rendering

**229. Should I learn ES6 before learning ReactJS?**
Yes, a solid understanding of ES6 features (like arrow functions, destructuring, and classes) is beneficial for working with React.

**230. What is Concurrent Rendering?**
Concurrent Rendering is a feature in React that allows rendering work to be split into smaller chunks, making apps more responsive.

### Async and ESLint

**231. What is the difference between async mode and concurrent mode?**
Async mode allows for non-blocking updates, while concurrent mode allows for more granular control over rendering and interruptions.

**232. Can I use JavaScript URLs in React 16.9?**
Yes, JavaScript URLs can be used, but they may pose security risks and should be avoided in production.

**233. What is the purpose of the ESLint plugin for hooks?**
The ESLint plugin for hooks helps enforce the rules of hooks, ensuring they are used correctly.

### Declarative vs Imperative

**234. What is the difference between Imperative and Declarative in React?**
Declarative programming describes what you want to achieve, while imperative programming describes how to achieve it. React promotes a declarative style.

### TypeScript Benefits

**235. What are the benefits of using TypeScript with ReactJS?**
TypeScript provides static type checking, better tooling, and improved code maintainability.

### Authentication with Context API

**236. How do you ensure that the user remains authenticated on page refresh while using Context API State Management?**
You can store the authentication status in localStorage or sessionStorage and read it on component mount.

### JSX Transform

**237. What are the benefits of the new JSX transform?**
The new JSX transform removes the need to import React for JSX files and improves the size of the compiled output.

**238. How is the new JSX transform different from the old transform?**
The new transform automatically imports necessary helpers without the need to import React explicitly, leading to cleaner code.

### Server Components and Prop Drilling

**239. What are React Server components?**
React Server components allow you to render components on the server, sending only the necessary data to the client.

**240. What is prop drilling?**
Prop drilling refers to the process of passing data through multiple levels of components, leading to cumbersome prop management.

### Hooks Comparison

**241. What is the difference between useState and useRef hook?**
`useState` triggers re-renders when the state changes, while `useRef` does not, allowing you to store mutable values without affecting rendering.

**242. What is a wrapper component?**
A wrapper component is a higher-order component that wraps another component, providing additional functionality or props.

### Effects and Components

**243. What are the differences between useEffect and useLayoutEffect hooks?**
`useEffect` runs asynchronously after the paint, while `useLayoutEffect` runs synchronously before the paint, allowing for more immediate DOM reads/writes.

**244. What are the differences between Functional and Class Components?**
Functional components are simpler and typically use hooks for state and lifecycle management, while class components rely on lifecycle methods and `this`.

### Strict Mode

**245. What is strict mode in React?**
Strict mode is a tool for highlighting potential problems in an application, enabling additional checks and warnings.

**246. What is the benefit of strict mode?**
It helps identify unsafe lifecycles, legacy API usage, and other potential issues.

**247. Why does strict mode render twice in React?**
Strict mode intentionally invokes components twice in development to help identify side effects and ensure that components are pure.

### JSX Guidelines

**248. What are the rules

 of JSX?**
- Must return a single parent element.
- Must use camelCase for attributes.
- Expressions must be wrapped in curly braces.

**249. What is the reason behind multiple JSX tags to be wrapped?**
JSX requires a single root element to represent the component's output in the virtual DOM.

### State Mutations

**250. How do you prevent mutating array variables?**
Use methods like `map`, `filter`, and `concat` that return new arrays instead of modifying the original.

**251. What are capture phase events?**
Capture phase events are when events propagate from the root to the target element, allowing for event handling before reaching the target.

### Screen Updates and Batching

**252. How does React update the screen in an application?**
React updates the screen by re-rendering components whose state or props have changed, using the diffing algorithm to optimize DOM updates.

**253. How does React batch multiple state updates?**
React batches state updates during event handlers and lifecycle methods to optimize performance.

**254. Is it possible to prevent automatic batching?**
Yes, automatic batching can be disabled in specific situations, such as using `unstable_batchedUpdates`.

### Hydration and State Updates

**255. What is React hydration?**
Hydration is the process of React attaching event listeners and making the server-rendered HTML interactive.

**256. How do you update objects inside state?**
You can use the spread operator to create a new object with updated properties.
```javascript
setState(prevState => ({
  ...prevState,
  property: newValue,
}));
```

**257. How do you update nested objects inside state?**
You can use the spread operator for nested properties.
```javascript
setState(prevState => ({
  ...prevState,
  nested: {
    ...prevState.nested,
    property: newValue,
  },
}));
```

**258. How do you update arrays inside state?**
Use methods like `map`, `filter`, or the spread operator to create a new array with the desired changes.
```javascript
setState(prevState => ({
  items: prevState.items.map(item => (item.id === targetId ? { ...item, updatedProp } : item)),
}));
```

**259. How do you use the immer library for state updates?**
Immer allows for simpler immutable updates by using a draft state that you can modify directly.
```javascript
import produce from 'immer';

setState(prevState => produce(prevState, draft => {
  draft.someProperty = newValue;
}));
```

### Direct Mutations and Array Operations

**260. What are the benefits of preventing direct state mutations?**
Preventing direct mutations ensures predictable state updates, easier debugging, and adherence to React's rendering lifecycle.

**261. What are the preferred and non-preferred array operations for updating the state?**
Preferred: `map`, `filter`, `concat`, `slice` (all create new arrays).  
Non-preferred: `push`, `pop`, `splice` (these modify the original array).

### Nested Components and Keys

**262. What will happen by defining nested function components?**
Nested function components will create a new component each time the parent re-renders, potentially leading to performance issues.

**263. Can I use keys for non-list items?**
Yes, keys can be used for non-list items, but they are primarily beneficial for maintaining component identity in lists.

### Reducers and useReducer

**264. What are the guidelines to be followed for writing reducers?**
- Must be pure functions.
- Should not mutate the state.
- Handle actions based on a type.

**265. What is useReducer hook? Can you describe its usage?**
`useReducer` is a hook for managing complex state logic. It takes a reducer function and an initial state, returning the current state and a dispatch function.
```javascript
const [state, dispatch] = useReducer(reducer, initialState);
```

**266. How do you compare useState and useReducer?**
`useState` is simpler and best for local state; `useReducer` is better for complex state logic or when the next state depends on the previous one.

### Context API and Client/Server Components

**267. How does context work using the useContext hook?**
The `useContext` hook allows you to access context values directly without needing to use a `Consumer` component.

**268. What are the use cases of the useContext hook?**
Use cases include theming, user authentication, and any shared state that needs to be accessed by multiple components.

**269. When to use client and server components?**
Client components are used for interactive UI elements, while server components are for rendering static content on the server.

### Routing in Next.js

**270. What are the differences between page router and app router in Next.js?**
The page router uses file-based routing, while the app router provides a more flexible, nested routing structure allowing for shared layouts and server components.


Table of Contents
Hide/Show table of contents
No.	Questions
Old Q&A
1	Why should we not update the state directly?
2	What is the purpose of callback function as an argument of setState()?
3	How to bind methods or event handlers in JSX callbacks?
4	How to pass a parameter to an event handler or callback?
5	What is the use of refs?
6	How to create refs?
7	What are forward refs?
8	Which is preferred option with in callback refs and findDOMNode()?
9	Why are String Refs legacy?
10	What are the different phases of component lifecycle?
11	What are the lifecycle methods of React?
12	How to create props proxy for HOC component?
13	What is context?
14	What is the purpose of using super constructor with props argument?
15	How to set state with a dynamic key name?
16	What would be the common mistake of function being called every time the component renders?
17	What are error boundaries in React v16
18	How are error boundaries handled in React v15?
19	What is the purpose of render method of react-dom?
20	What will happen if you use setState in constructor?
21	Is it good to use setState() in componentWillMount() method?
22	What will happen if you use props in initial state?
23	How you use decorators in React?
24	What is CRA and its benefits?
25	What is the lifecycle methods order in mounting?
26	What are the lifecycle methods going to be deprecated in React v16?
27	What is the purpose of getDerivedStateFromProps() lifecycle method?
28	What is the purpose of getSnapshotBeforeUpdate() lifecycle method?
29	What is the recommended way for naming components?
30	What is the recommended ordering of methods in component class?
31	Why we need to pass a function to setState()?
32	Why is isMounted() an anti-pattern and what is the proper solution?
33	What is the difference between constructor and getInitialState?
34	Can you force a component to re-render without calling setState?
35	What is the difference between super() and super(props) in React using ES6 classes?
36	What is the difference between setState and replaceState methods?
37	How to listen to state changes?
38	What is the recommended approach of removing an array element in react state?
39	Is it possible to use React without rendering HTML?
40	What are the possible ways of updating objects in state?
41	What are the approaches to include polyfills in your create-react-app?
42	How to use https instead of http in create-react-app?
43	How to avoid using relative path imports in create-react-app?
44	How to update a component every second?
45	Why is a component constructor called only once?
46	How to define constants in React?
47	How to programmatically trigger click event in React?
48	How to make AJAX call and In which component lifecycle methods should I make an AJAX call?
49	What are render props?
50	How to dispatch an action on load?
51	How to use connect from React Redux?
52	Whats the purpose of at symbol in the redux connect decorator?
53	How to use TypeScript in create-react-app application?
54	Does the statics object work with ES6 classes in React?
55	Why are inline ref callbacks or functions not recommended?
56	What are HOC factory implementations?
57	How to use class field declarations syntax in React classes?
58	Why do you not need error boundaries for event handlers?
59	What is the difference between try catch block and error boundaries?
60	What is the required method to be defined for a class component?
61	What are the possible return types of render method?
62	What is the main purpose of constructor?
63	Is it mandatory to define constructor for React component?
64	Why should not call setState in componentWillUnmount?
65	What is the purpose of getDerivedStateFromError?
66	What is the methods order when component re-rendered?
67	What are the methods invoked during error handling?
68	What is the purpose of unmountComponentAtNode method?
69	What are the limitations with HOCs?
70	How to debug forwardRefs in DevTools?
71	Is it good to use arrow functions in render methods?
72	How do you say that state updates are merged?
73	How do you pass arguments to an event handler?
74	How to prevent component from rendering?
75	Give an example on How to use context?
76	How do you use contextType?
77	What is a consumer?
78	How do you solve performance corner cases while using context?
79	What is the purpose of forward ref in HOCs?
80	Is it ref argument available for all functions or class components?
81	Why do you need additional care for component libraries while using forward refs?
82	How to create react class components without ES6?
83	Is it possible to use react without JSX?
84	How do you create HOC using render props?
85	What is react scripts?
86	What are the features of create react app?
87	What is the purpose of renderToNodeStream method?
88	How do you get redux scaffolding using create-react-app?
89	What is state mutation and how to prevent it?

Sure! Here's a concise explanation for each of your questions about React:

1. **Why should we not update the state directly?**  
   Directly updating state can lead to unpredictable behavior because React may not recognize that a change has occurred, which can prevent re-renders and lead to stale UI.

2. **What is the purpose of callback function as an argument of setState()?**  
   The callback function is invoked after the state has been updated and the component has re-rendered, allowing you to perform actions that depend on the updated state.

3. **How to bind methods or event handlers in JSX callbacks?**  
   You can bind methods using the `.bind()` method in the constructor or use arrow functions to automatically bind `this`. Example:
   ```javascript
   this.handleClick = this.handleClick.bind(this);
   ```

4. **How to pass a parameter to an event handler or callback?**  
   You can use an arrow function to pass parameters. Example:
   ```javascript
   <button onClick={() => this.handleClick(param)}>Click Me</button>
   ```

5. **What is the use of refs?**  
   Refs provide a way to access DOM nodes or React elements created in the render method, allowing you to interact directly with them.

6. **How to create refs?**  
   You can create refs using `React.createRef()` or the `useRef` hook in functional components.

7. **What are forward refs?**  
   Forward refs allow you to pass a ref through a component to a child component, enabling the parent to directly interact with the child's DOM node.

8. **Which is preferred option within callback refs and findDOMNode()?**  
   Callback refs are preferred over `findDOMNode()` because they are safer and work better with the React lifecycle.

9. **Why are String Refs legacy?**  
   String refs are considered legacy because they can lead to confusing code and are less flexible than callback refs.

10. **What are the different phases of component lifecycle?**  
    The lifecycle phases are Mounting, Updating, and Unmounting.

11. **What are the lifecycle methods of React?**  
    Key lifecycle methods include `componentDidMount`, `componentDidUpdate`, `componentWillUnmount`, `shouldComponentUpdate`, etc.

12. **How to create props proxy for HOC component?**  
    By using a higher-order component (HOC) that wraps the original component and passes props to it, allowing you to modify or add props.

13. **What is context?**  
    Context provides a way to pass data through the component tree without having to pass props down manually at every level.

14. **What is the purpose of using super constructor with props argument?**  
    Using `super(props)` in a class component constructor allows you to access `this.props` in your constructor.

15. **How to set state with a dynamic key name?**  
    You can use computed property names to set state dynamically:
    ```javascript
    this.setState({ [dynamicKey]: value });
    ```

16. **What would be the common mistake of function being called every time the component renders?**  
    Defining a function directly inside the render method without wrapping it in an arrow function or binding it can lead to unnecessary re-executions.

17. **What are error boundaries in React v16?**  
    Error boundaries are components that catch JavaScript errors in their child component tree, preventing crashes and allowing for fallback UI.

18. **How are error boundaries handled in React v15?**  
    React v15 does not support error boundaries; errors would cause the entire component tree to unmount.

19. **What is the purpose of render method of react-dom?**  
    The `render` method is used to render a React component into the DOM.

20. **What will happen if you use setState in constructor?**  
    Calling `setState` in the constructor won't trigger a re-render because the component hasn't mounted yet.

21. **Is it good to use setState() in componentWillMount() method?**  
    No, `componentWillMount` is not recommended for `setState` as it may lead to inconsistent behavior and it's deprecated in newer versions.

22. **What will happen if you use props in initial state?**  
    If you use props to set initial state, any updates to the props after the initial render won't update the state, leading to stale data.

23. **How you use decorators in React?**  
    Decorators can be used to modify class properties or methods in a clean way, often seen in HOCs or with libraries like `mobx`.

24. **What is CRA and its benefits?**  
    Create React App (CRA) is a tool to set up a new React project with a sensible default configuration, making it easier to start projects without configuring build tools.

25. **What is the lifecycle methods order in mounting?**  
    The order is: `constructor`, `getDerivedStateFromProps`, `render`, `componentDidMount`.

26. **What are the lifecycle methods going to be deprecated in React v16?**  
    Methods like `componentWillMount`, `componentWillReceiveProps`, and `componentWillUpdate` are deprecated.

27. **What is the purpose of getDerivedStateFromProps() lifecycle method?**  
    It allows a component to update its state based on changes in props, without causing additional renders.

28. **What is the purpose of getSnapshotBeforeUpdate() lifecycle method?**  
    This method allows you to capture some information from the DOM (like scroll position) before the changes are applied.

29. **What is the recommended way for naming components?**  
    Components should be named using PascalCase to distinguish them from HTML elements.

30. **What is the recommended ordering of methods in component class?**  
    Typically, the order is: constructor, lifecycle methods (mounting, updating, unmounting), and render methods.

31. **Why do we need to pass a function to setState()?**  
    Passing a function to `setState` allows you to update the state based on the previous state, ensuring the correct value is used.

32. **Why is isMounted() an anti-pattern and what is the proper solution?**  
    `isMounted` can lead to unexpected behavior; instead, use lifecycle methods to manage the component's mounting status.

33. **What is the difference between constructor and getInitialState?**  
    In React class components, `constructor` is used to initialize state and bind methods, while `getInitialState` was used in older versions to define initial state (not used anymore).

34. **Can you force a component to re-render without calling setState?**  
    It is not recommended, but you can use `forceUpdate()`; however, this bypasses React's state management.

35. **What is the difference between super() and super(props) in React using ES6 classes?**  
    `super()` calls the parent class's constructor without passing props, while `super(props)` allows you to access props in the constructor.

36. **What is the difference between setState and replaceState methods?**  
    `setState` merges the new state with the existing state, while `replaceState` replaces the state entirely.

37. **How to listen to state changes?**  
    You can use `componentDidUpdate` lifecycle method to respond to state changes.

38. **What is the recommended approach of removing an array element in react state?**  
    Use the `filter` method to create a new array excluding the element to be removed, then update the state.

39. **Is it possible to use React without rendering HTML?**  
    Yes, React can be used to manage any data flow or state without rendering HTML, such as in Node.js environments.

40. **What are the possible ways of updating objects in state?**  
    Use `setState` with a callback function, spread operator, or utility functions like `immer` for immutable updates.

41. **What are the approaches to include polyfills in your create-react-app?**  
    You can include polyfills in your `index.js` or by using libraries like `core-js`.

42. **How to use HTTPS instead of HTTP in create-react-app?**  
    Set the `HTTPS=true` environment variable in your `.env` file.

43. **How to avoid using relative path imports in create-react-app?**  
    You can configure absolute imports by adding a `baseUrl` in the `jsconfig.json` or `tsconfig.json` file.

44. **How to update a component every second?**  
    You can use `setInterval` inside `componentDidMount` and clear it in `componentWillUnmount`.

45. **Why is a component constructor called only once?**  
    The constructor is only called when the component is first initialized; subsequent updates do not require re-initialization.

46. **How to define constants in React?**  
    You can define constants at the top of your component file or within the component itself.

47. **How to programmatically trigger click event in React?**  
    Use refs to access the DOM node and call the `click()` method on it.

48. **How to make AJAX call and in which component lifecycle methods should I make an AJAX call?**  
    Use `componentDidMount` for AJAX calls to fetch data after the component mounts.

49. **What are render props?**  
    Render props are a technique for sharing code between components using a prop that is a function, which returns a React element.

50. **How to dispatch an action on load?**  
    You can dispatch an action within `componentDidMount` or using a hook like `useEffect` in functional components.

51.

 **How to use connect from React Redux?**  
    Use the `connect` function to connect your component to the Redux store, mapping state and dispatch to props.

52. **What's the purpose of the `@` symbol in the Redux connect decorator?**  
    It is used to signify that `connect` is a higher-order component.

53. **How to use TypeScript in create-react-app application?**  
    You can create a new app with TypeScript by running `npx create-react-app my-app --template typescript`.

54. **Does the statics object work with ES6 classes in React?**  
    Yes, you can define static properties and methods in ES6 classes.

55. **Why are inline ref callbacks or functions not recommended?**  
    Inline functions can cause performance issues by creating a new function on every render, leading to unnecessary re-renders.

56. **What are HOC factory implementations?**  
    HOC factories are functions that return a higher-order component, often used to encapsulate logic.

57. **How to use class field declarations syntax in React classes?**  
    You can declare class fields directly in the class body, avoiding the need for binding in the constructor.

58. **Why do you not need error boundaries for event handlers?**  
    Event handlers do not bubble up to parent components, so errors can be caught directly within the handler.

59. **What is the difference between try-catch block and error boundaries?**  
    Try-catch handles synchronous errors, while error boundaries handle errors in rendering, lifecycle methods, and constructors.

60. **What is the required method to be defined for a class component?**  
    The `render` method is required for class components.

61. **What are the possible return types of the render method?**  
    The render method can return `null`, a React element, or an array of React elements.

62. **What is the main purpose of the constructor?**  
    The constructor is used for initializing state and binding methods.

63. **Is it mandatory to define a constructor for a React component?**  
    No, a constructor is not mandatory; you can define state directly as a class property.

64. **Why should you not call setState in componentWillUnmount?**  
    Calling `setState` in `componentWillUnmount` can lead to memory leaks and unexpected behavior since the component is about to be removed.

65. **What is the purpose of getDerivedStateFromError?**  
    This method allows you to update the state when an error is caught, enabling fallback UI.

66. **What is the methods order when component re-rendered?**  
    The order is: `getDerivedStateFromProps`, `shouldComponentUpdate`, `render`, `getSnapshotBeforeUpdate`, `componentDidUpdate`.

67. **What are the methods invoked during error handling?**  
    `getDerivedStateFromError` and `componentDidCatch` are invoked when an error occurs.

68. **What is the purpose of unmountComponentAtNode method?**  
    It is used to unmount a React component from the DOM node.

69. **What are the limitations with HOCs?**  
    HOCs can lead to wrapper hell, make debugging difficult, and may pass down unnecessary props to wrapped components.

70. **How to debug forwardRefs in DevTools?**  
    Use the React DevTools to inspect components, and you can see the forwarded refs in the component tree.

71. **Is it good to use arrow functions in render methods?**  
    It's generally discouraged because it creates a new function on each render, which can hurt performance.

72. **How do you say that state updates are merged?**  
    `setState` merges the new state with the current state rather than replacing it entirely.

73. **How do you pass arguments to an event handler?**  
    You can use arrow functions or `bind` to pass arguments to an event handler.

74. **How to prevent a component from rendering?**  
    You can use `shouldComponentUpdate` or return `null` from the render method to prevent rendering.

75. **Give an example of how to use context.**  
    Create a Context using `React.createContext()`, then use `Provider` to pass data and `Consumer` to access it.

76. **How do you use contextType?**  
    Set `contextType` on a class component to consume context directly, allowing you to access it via `this.context`.

77. **What is a consumer?**  
    A Consumer is a component that subscribes to context changes and can access the current context value.

78. **How do you solve performance corner cases while using context?**  
    You can split context into smaller contexts or use memoization to avoid unnecessary re-renders.

79. **What is the purpose of forward ref in HOCs?**  
    It allows HOCs to pass refs to wrapped components, enabling direct access to the DOM nodes.

80. **Is the ref argument available for all functions or class components?**  
    The ref argument is available for class components and functional components using `React.forwardRef`.

81. **Why do you need additional care for component libraries while using forward refs?**  
    Component libraries need to ensure that refs are passed correctly to allow users to interact with their components effectively.

82. **How to create React class components without ES6?**  
    You can create class components using `React.createClass()` (deprecated) or by defining a function that returns JSX.

83. **Is it possible to use React without JSX?**  
    Yes, you can use React without JSX by using `React.createElement()` to create elements.

84. **How do you create HOC using render props?**  
    Create a component that accepts a render function as a prop, which allows you to inject props or state.

85. **What is react scripts?**  
    React Scripts is a package that includes scripts and configuration used by Create React App, simplifying the setup process.

86. **What are the features of create-react-app?**  
    It provides a zero-config setup, built-in development server, hot module replacement, and optimized production builds.

87. **What is the purpose of renderToNodeStream method?**  
    It allows server-side rendering of React components, streaming the HTML to the client as it is generated.

88. **How do you get redux scaffolding using create-react-app?**  
    You can set up Redux in a Create React App by installing Redux and React-Redux, and configuring the store and provider.

89. **What is state mutation and how to prevent it?**  
    State mutation occurs when you change the state directly. To prevent it, use immutable patterns, such as the spread operator or libraries like `immer`.

