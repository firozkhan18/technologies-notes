# Senior React Developer Interview Preparation Guide

This guide follows the same structure as the Java and Angular preparation guides, with interview-ready answers, practical React code examples, real-world scenarios, performance optimization, architecture and coding questions.

It covers React 18 and React 19, including Hooks, Context API, Redux Toolkit, React Server Components, Suspense, concurrent rendering and modern application architecture.

Writing

# Senior React Developer Interview Preparation Guide

## Complete Questions and Answers – Senior Frontend Developer

**Topics:** React, JavaScript, TypeScript, JSX, Components, Props, State, Hooks, Redux, Context API, React Router, API Integration, Performance Optimization, Testing, Security and Frontend System Design.

---

# PART 1: TOP 20 SENIOR REACT INTERVIEW QUESTIONS

## 1\. What is React and how does it work?

**Answer:**

React is a JavaScript library used to build user interfaces, particularly single-page applications.

React uses a component-based architecture.

Important concepts:

1. Components – Reusable UI building blocks.
2. JSX – JavaScript syntax extension for describing UI.
3. Props – Data passed from parent to child components.
4. State – Component-managed data.
5. Hooks – Functions that allow components to use React features.
6. Virtual DOM – An in-memory representation of the UI.
7. Reconciliation – Determines what changes are needed in the rendered UI.
8. React Fiber – React's internal rendering architecture.

Typical architecture:

text

```text
React Application
       |
       v
     App
       |
       v
   Components
       |
       v
    Hooks
       |
       v
    Services
       |
       v
    REST APIs
       |
       v
   Java Backend
```

React uses declarative rendering: developers describe what the UI should look like for a given state.

---

## 2\. What is the difference between React and Angular?

**Answer:**

| React | Angular |
| --- | --- |
| UI library | Complete frontend framework |
| JavaScript/TypeScript | TypeScript |
| JSX | HTML templates |
| Uses external routing libraries commonly | Built-in Router |
| State management through Hooks and libraries | Services, Signals and RxJS |
| Flexible architecture | More opinionated architecture |
| Virtual DOM and reconciliation | Angular rendering and change detection |
| Flexible dependency choices | Built-in dependency injection |

React provides more architectural flexibility, whereas Angular provides more built-in application infrastructure.

---

## 3\. What is JSX?

**Answer:**

JSX stands for JavaScript XML.

It allows developers to write HTML-like syntax inside JavaScript.

Example:

jsx

```jsx
function User() {
  const name = "John";

  return (
    <div>
      <h2>{name}</h2>
    </div>
  );
}
```

JSX is transformed into JavaScript calls that create React elements.

Advantages:

- Readable UI code.
- Component composition.
- JavaScript expressions inside templates.
- Easier UI development.

Important: JSX is not HTML. For example, use `className` instead of `class`.

---

## 4\. What is the difference between props and state?

**Answer:**

Props are inputs passed from parent components.

State is data managed by a component or shared through an appropriate state-management mechanism.

| Props | State |
| --- | --- |
| Passed from parent | Managed by component |
| Read-only inside receiving component | Updated using state setters |
| Used for component configuration | Used for dynamic data |
| Changes when parent provides new values | Changes through state updates |

Example:

jsx

```jsx
function User({ name }) {
  const [age, setAge] = useState(25);

  return (
    <>
      <h2>{name}</h2>
      <p>{age}</p>

      <button onClick={() => setAge(age + 1)}>
        Increase Age
      </button>
    </>
  );
}
```

---

## 5\. What is the Virtual DOM?

**Answer:**

The Virtual DOM is an in-memory representation of the UI.

When state or props change:

1. React renders the component.
2. React creates a new element tree.
3. Reconciliation compares the new tree with the previous tree.
4. React determines the necessary updates.
5. The renderer applies those updates to the actual UI.

Benefits:

- Declarative programming.
- Efficient UI updates.
- Component-driven development.
- Easier state-based rendering.

Senior-level point:

Virtual DOM does not mean every update is automatically faster than direct DOM manipulation. Performance depends on component structure, reconciliation and rendering work.

---

## 6\. What is reconciliation in React?

**Answer:**

Reconciliation is the process React uses to determine how the rendered UI should change when elements or component state change.

React uses element types, positions and keys to identify elements.

Example:

jsx

```jsx
{users.map(user => (
  <UserCard
    key={user.id}
    user={user}
  />
))}
```

Stable keys help React correctly identify list items when items are inserted, removed or reordered.

Avoid array indexes as keys when the list can change dynamically.

---

## 7\. What are React Hooks?

**Answer:**

Hooks allow functional components to use React features such as state, context and lifecycle-related behavior.

Important Hooks:

| Hook | Purpose |
| --- | --- |
| useState | Local component state |
| useEffect | Synchronize with external systems |
| useContext | Consume context |
| useRef | Maintain mutable references |
| useMemo | Cache calculated values |
| useCallback | Cache function references |
| useReducer | Manage complex state |
| useLayoutEffect | Run effect after DOM mutations before repaint |
| useId | Generate stable IDs |
| useTransition | Mark updates as non-urgent |
| useDeferredValue | Defer updating a value |
| useSyncExternalStore | Subscribe to external stores |

Example:

jsx

```jsx
function Counter() {
  const [count, setCount] = useState(0);

  return (
    <button onClick={() => setCount(c => c + 1)}>
      Count: {count}
    </button>
  );
}
```

---

## 8\. Explain useState and useEffect.

**Answer:**

`useState` manages component state.

`useEffect` synchronizes a component with external systems, such as APIs, subscriptions, timers and browser events.

Example:

jsx

```jsx
function Users() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('/api/users')
      .then(res => res.json())
      .then(data => setUsers(data));
  }, []);

  return (
    <div>
      {users.map(user => (
        <p key={user.id}>{user.name}</p>
      ))}
    </div>
  );
}
```

Dependency array behavior:

jsx

```jsx
useEffect(() => {
  // Runs after every relevant commit
});

useEffect(() => {
  // Runs on mount and when unmounted for cleanup
}, []);

useEffect(() => {
  // Runs when userId changes
}, [userId]);
```

Important senior-level points:

- Effects should not be used for every calculation.
- Derived state can often be calculated during rendering.
- Effects need cleanup for subscriptions and external resources.
- React Strict Mode may run an extra setup and cleanup cycle in development.

---

## 9\. What is the difference between useEffect and useLayoutEffect?

**Answer:**

| useEffect | useLayoutEffect |
| --- | --- |
| Runs after the browser has had an opportunity to paint | Runs after DOM mutations and before repaint |
| Does not block painting in typical cases | Can block painting |
| Suitable for most side effects | Suitable for layout measurement |
| Preferred default | Use only when necessary |

Example:

jsx

```jsx
useLayoutEffect(() => {
  const height =
    elementRef.current.getBoundingClientRect().height;

  setHeight(height);
}, []);
```

Use `useEffect` for ordinary API requests and subscriptions.

---

## 10\. What is the difference between useMemo and useCallback?

**Answer:**

Both are performance optimization Hooks.

`useMemo` caches a calculated value.

`useCallback` caches a function reference.

Example:

jsx

```jsx
const filteredUsers = useMemo(() => {
  return users.filter(user =>
    user.name.includes(search)
  );
}, [users, search]);
```

jsx

```jsx
const handleClick = useCallback(() => {
  console.log('Clicked');
}, []);
```

Difference:

| useMemo | useCallback |
| --- | --- |
| Returns cached value | Returns cached function |
| Useful for expensive calculations | Useful for stable callback references |

Avoid using them everywhere. Measure performance and use them when they provide a meaningful benefit.

---

## 11\. What is React Context API?

**Answer:**

Context API allows data to be shared across components without passing props through every intermediate component.

Example:

jsx

```jsx
const AuthContext = createContext(null);

function App() {
  const [user, setUser] = useState(null);

  return (
    <AuthContext.Provider
      value={{ user, setUser }}
    >
      <Dashboard />
    </AuthContext.Provider>
  );
}
```

Consume:

jsx

```jsx
function Profile() {
  const auth = useContext(AuthContext);

  return <h2>{auth?.user?.name}</h2>;
}
```

Common use cases:

- Authentication information.
- Theme.
- Language preferences.
- Application configuration.

Context is not automatically a complete replacement for Redux.

---

## 12\. What is Redux and why is it used?

**Answer:**

Redux is a predictable state-management library.

It helps manage shared application state in a centralized store.

Main concepts:

1. Store.
2. Actions.
3. Reducers.
4. Dispatch.
5. Selectors.
6. Middleware.

Architecture:

text

```text
Component
    |
    v
  Dispatch
    |
    v
  Action
    |
    v
 Reducer
    |
    v
  Store
    |
    v
 Selector
    |
    v
 Component
```

Redux Toolkit is the recommended approach for modern Redux applications.

Benefits:

- Centralized state.
- Predictable updates.
- Easier debugging.
- Middleware support.
- Better management of complex application workflows.

---

## 13\. What is Redux Toolkit?

**Answer:**

Redux Toolkit simplifies Redux development.

Important APIs:

- configureStore.
- createSlice.
- createAsyncThunk.
- createSelector.
- RTK Query.

Example:

jsx

```jsx
const userSlice = createSlice({
  name: 'user',

  initialState: {
    user: null
  },

  reducers: {
    setUser: (state, action) => {
      state.user = action.payload;
    }
  }
});
```

Redux Toolkit uses Immer internally to provide immutable state updates with convenient syntax.

---

## 14\. What is React Router?

**Answer:**

React Router is a routing library used for navigation in React applications.

Example:

jsx

```jsx
import {
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route
          path="/"
          element={<Home />}
        />

        <Route
          path="/users"
          element={<Users />}
        />
      </Routes>
    </BrowserRouter>
  );
}
```

Important concepts:

- BrowserRouter.
- Routes.
- Route.
- Link.
- Navigate.
- useNavigate.
- useParams.
- Nested routes.
- Loaders and actions in supported router configurations.

---

## 15\. What are controlled and uncontrolled components?

**Answer:**

Controlled components store form values in React state.

Uncontrolled components manage values through the DOM and refs.

Controlled example:

jsx

```jsx
function Login() {
  const [email, setEmail] = useState('');

  return (
    <input
      value={email}
      onChange={e => setEmail(e.target.value)}
    />
  );
}
```

Uncontrolled example:

jsx

```jsx
function Login() {
  const emailRef = useRef(null);

  function submit() {
    console.log(emailRef.current.value);
  }

  return (
    <>
      <input ref={emailRef} />
      <button onClick={submit}>Submit</button>
    </>
  );
}
```

Controlled inputs are useful for validation and dynamic UI behavior.

Uncontrolled inputs can be useful for simpler forms and integration with certain DOM-based libraries.

---

## 16\. What is React.memo?

**Answer:**

React.memo is a higher-order component that can skip rendering a component when its props are unchanged according to its comparison.

Example:

jsx

```jsx
const User = React.memo(function User({ user }) {
  return <h2>{user.name}</h2>;
});
```

It is useful when:

- A component renders frequently.
- Its props usually remain unchanged.
- Rendering is expensive.

Important: React.memo does not prevent rendering when the component's own state or consumed context changes.

---

## 17\. What is useRef?

**Answer:**

useRef stores a mutable value that persists across renders without triggering a re-render when changed.

Example:

jsx

```jsx
function Search() {
  const inputRef = useRef(null);

  function focusInput() {
    inputRef.current.focus();
  }

  return (
    <>
      <input ref={inputRef} />
      <button onClick={focusInput}>
        Focus
      </button>
    </>
  );
}
```

Use cases:

- DOM access.
- Timer IDs.
- Previous values.
- Mutable values not required for rendering.

---

## 18\. What are React Fragments?

**Answer:**

Fragments allow multiple elements to be grouped without adding an extra DOM element.

jsx

```jsx
function User() {
  return (
    <>
      <h2>John</h2>
      <p>Developer</p>
    </>
  );
}
```

Useful for avoiding unnecessary wrapper elements.

---

## 19\. What are Error Boundaries?

**Answer:**

Error Boundaries catch rendering errors in their child component tree and display fallback UI.

They do not generally catch errors in event handlers, asynchronous callbacks or server-side rendering.

Example:

jsx

```jsx
class ErrorBoundary extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      hasError: false
    };
  }

  static getDerivedStateFromError() {
    return {
      hasError: true
    };
  }

  componentDidCatch(error, info) {
    console.error(error, info);
  }

  render() {
    if (this.state.hasError) {
      return <h2>Something went wrong.</h2>;
    }

    return this.props.children;
  }
}
```

Use Error Boundaries around important application sections to prevent one component failure from breaking the entire UI.

---

## 20\. What are React Server Components?

**Answer:**

React Server Components allow components to render on the server without sending their component implementation to the browser as client-side JavaScript.

Benefits:

- Reduced client-side JavaScript for suitable components.
- Server-side data access.
- Improved separation between server and client functionality.

Important distinctions:

- Server Components are not the same as traditional SSR.
- Client Components are required for browser interactions and client-side Hooks such as useState.
- Server and Client Component support depends on the React framework and its configuration.

---

# PART 2: JAVASCRIPT AND TYPESCRIPT – 15 QUESTIONS

## 21\. Difference between var, let and const?

| Feature | var | let | const |
| --- | --- | --- | --- |
| Scope | Function | Block | Block |
| Reassignment | Yes | Yes | No |
| Redeclaration | Yes | No | No |
| Temporal dead zone | No | Yes | Yes |

Prefer const by default and let when reassignment is necessary.

## 22\. What is closure?

A closure is a function that retains access to variables from its lexical scope.

javascript

```javascript
function counter() {
  let count = 0;

  return function() {
    return ++count;
  };
}

const increment = counter();

increment(); // 1
increment(); // 2
```

## 23\. What is the JavaScript event loop?

The event loop coordinates synchronous JavaScript execution and asynchronous callbacks.

Important concepts:

- Call stack.
- Web APIs.
- Task queue.
- Microtask queue.

Promise callbacks are microtasks, while setTimeout callbacks are tasks.

## 24\. What is Promise vs Observable?

| Promise | Observable |
| --- | --- |
| One eventual result | Zero or more values |
| Eager once created | Usually lazy |
| No standard cancellation | Supports unsubscription |
| Native JavaScript | RxJS library |
| Limited composition | Rich operators |

React commonly uses Promises for asynchronous API operations, while RxJS can be integrated when stream-based processing is needed.

## 25\. What is shallow copy vs deep copy?

Shallow copy:

javascript

```javascript
const copy = { ...user };
```

Deep copy for supported structured-cloneable data:

javascript

```javascript
const deepCopy = structuredClone(user);
```

## 26\. What is map, filter and reduce?

javascript

```javascript
const numbers = [1, 2, 3, 4];

const doubled = numbers.map(n => n * 2);

const even = numbers.filter(n => n % 2 === 0);

const total = numbers.reduce(
  (sum, n) => sum + n,
  0
);
```

## 27\. What is destructuring?

javascript

```javascript
const user = {
  name: 'John',
  age: 30
};

const { name, age } = user;
```

It extracts values from objects or arrays.

## 28\. What is optional chaining?

javascript

```javascript
const city = user?.address?.city;
```

It safely accesses nested properties when an intermediate value is null or undefined.

## 29\. What is nullish coalescing?

javascript

```javascript
const name = user.name ?? 'Guest';
```

It provides a fallback only for null or undefined.

## 30\. What is the difference between == and ===?

`==` allows type coercion.

`===` performs strict equality comparison.

Prefer strict equality.

## 31\. What is hoisting?

JavaScript processes declarations before executing code.

Function declarations can be called before their declaration.

Variables declared using let and const remain in the temporal dead zone until initialization.

## 32\. What are async and await?

They provide syntax for working with Promises.

javascript

```javascript
async function getUsers() {
  const response = await fetch('/api/users');

  return response.json();
}
```

## 33\. What are call, apply and bind?

They control function execution context.

- call: individual arguments.
- apply: array of arguments.
- bind: returns a new function.

## 34\. What are TypeScript interfaces and types?

Interface:

typescript

```typescript
interface User {
  id: number;
  name: string;
}
```

Type:

typescript

```typescript
type User = {
  id: number;
  name: string;
};
```

Both describe data structures. Type aliases also support unions, intersections and other type expressions.

## 35\. What are generics?

Generics enable reusable, type-safe code.

typescript

```typescript
function identity<T>(value: T): T {
  return value;
}

const result = identity<string>('React');
```

---

# PART 3: REACT PERFORMANCE OPTIMIZATION – 12 QUESTIONS

## 36\. How do you improve React application performance?

**Answer:**

I first identify the actual performance bottleneck using browser profiling and React DevTools.

Optimization techniques:

1. React.memo.
2. useMemo.
3. useCallback.
4. Code splitting.
5. Lazy loading.
6. Virtualization.
7. Avoid unnecessary state updates.
8. Optimize component hierarchy.
9. Reduce bundle size.
10. Optimize API calls.
11. Use appropriate caching.
12. Optimize images.

Example:

jsx

```jsx
const filteredUsers = useMemo(() => {
  return users.filter(user =>
    user.name.toLowerCase().includes(
      search.toLowerCase()
    )
  );
}, [users, search]);
```

Do not optimize blindly. Measure first.

## 37\. What is React lazy loading?

Lazy loading loads components only when required.

jsx

```jsx
const Dashboard = React.lazy(
  () => import('./Dashboard')
);

function App() {
  return (
    <Suspense fallback={<p>Loading...</p>}>
      <Dashboard />
    </Suspense>
  );
}
```

Benefits:

- Smaller initial bundle.
- Faster initial loading.
- Better code separation.

## 38\. What is code splitting?

Code splitting divides the JavaScript bundle into smaller chunks.

It can be implemented using dynamic imports.

javascript

```javascript
const module = await import('./reports');
```

It reduces the amount of JavaScript required during initial loading.

## 39\. What is list virtualization?

Virtualization renders only visible rows of a large list.

Libraries include:

- react-window.
- TanStack Virtual.

Useful for tables containing thousands of records.

## 40\. How do you prevent unnecessary re-renders?

**Answer:**

- Use React.memo when beneficial.
- Keep state close to where it is used.
- Avoid unnecessary context updates.
- Use stable keys.
- Avoid creating unnecessary object/function props.
- Use memoization selectively.
- Split large components.
- Use React DevTools Profiler.

## 41\. What is concurrent rendering?

Concurrent rendering allows React to prepare and prioritize rendering work.

React can interrupt non-urgent rendering work to respond to more urgent updates.

It is not the same as running JavaScript component rendering in parallel across multiple CPU threads.

## 42\. What is useTransition?

It marks state updates as non-urgent.

jsx

```jsx
const [isPending, startTransition] =
  useTransition();

function handleSearch(value) {
  setInput(value);

  startTransition(() => {
    setSearch(value);
  });
}
```

Useful when an expensive UI update should not block immediate user interactions.

## 43\. What is useDeferredValue?

It allows a value used for non-urgent rendering to lag behind the latest value.

jsx

```jsx
const deferredSearch =
  useDeferredValue(search);

const filtered = useMemo(() => {
  return users.filter(user =>
    user.name.includes(deferredSearch)
  );
}, [users, deferredSearch]);
```

It can help keep input interactions responsive.

## 44\. What is Suspense?

Suspense allows a component tree to display fallback UI while supported child operations are waiting.

jsx

```jsx
<Suspense fallback={<p>Loading...</p>}>
  <Dashboard />
</Suspense>
```

Common use cases include lazy-loaded components and supported framework data-loading integrations.

## 45\. What causes memory leaks in React?

**Answer:**

Possible causes:

- Uncleaned subscriptions.
- Unremoved event listeners.
- Timers that remain active.
- WebSocket connections not closed.
- Unmanaged external resources.
- Large retained caches.

Example cleanup:

jsx

```jsx
useEffect(() => {
  const timer = setInterval(() => {
    console.log('Running');
  }, 1000);

  return () => {
    clearInterval(timer);
  };
}, []);
```

Use Chrome DevTools memory profiling to investigate retained objects and growing memory usage.

## 46\. How do you optimize API calls?

**Answer:**

- Debounce search requests.
- Cancel outdated requests.
- Cache appropriate responses.
- Avoid duplicate requests.
- Use pagination.
- Use server-side filtering.
- Use TanStack Query or RTK Query where appropriate.

Example:

jsx

```jsx
useEffect(() => {
  const controller = new AbortController();

  fetch(`/api/users?q=${search}`, {
    signal: controller.signal
  })
    .then(res => res.json())
    .then(setUsers)
    .catch(error => {
      if (error.name !== 'AbortError') {
        console.error(error);
      }
    });

  return () => controller.abort();
}, [search]);
```

## 47\. What is tree shaking?

Tree shaking removes unused code during bundling when the module format and build tooling support static analysis.

Benefits:

- Smaller bundles.
- Less unnecessary JavaScript.
- Better loading performance.

---

# PART 4: REACT ARCHITECTURE AND ADVANCED CONCEPTS

## 48\. How do you structure a large React application?

**Answer:**

I prefer feature-based architecture.

text

```text
src/
  app/
    routes/
    providers/

  features/
    auth/
      components/
      hooks/
      services/
      types/

    users/
      components/
      pages/
      hooks/
      services/
      types/

    orders/
      components/
      pages/
      hooks/
      services/

  shared/
    components/
    hooks/
    utils/

  services/
    api/
    http/

  store/
    slices/

  assets/
```

Benefits:

- Feature isolation.
- Easier maintenance.
- Reusable components.
- Better team ownership.
- Improved scalability.

## 49\. What is the difference between Context API and Redux?

| Context API | Redux Toolkit |
| --- | --- |
| Built into React | External library |
| Simple shared values | Complex application state |
| No built-in reducers or middleware architecture | Structured state management |
| Less setup | More infrastructure |
| Context consumers update when context changes | Selectors can subscribe to selected state |

Use Context for suitable shared values.

Use Redux Toolkit when complex state transitions, middleware and centralized workflows are required.

## 50\. What is the difference between useState and useReducer?

useState is suitable for simple state.

useReducer is suitable for complex state transitions.

Example:

jsx

```jsx
function reducer(state, action) {
  switch (action.type) {
    case 'increment':
      return {
        count: state.count + 1
      };

    case 'decrement':
      return {
        count: state.count - 1
      };

    default:
      return state;
  }
}

function Counter() {
  const [state, dispatch] =
    useReducer(reducer, { count: 0 });

  return (
    <button
      onClick={() => dispatch({
        type: 'increment'
      })}
    >
      {state.count}
    </button>
  );
}
```

## 51\. What is a Higher Order Component?

A Higher Order Component (HOC) is a function that takes a component and returns an enhanced component.

jsx

```jsx
function withLoading(Component) {
  return function EnhancedComponent({
    loading,
    ...props
  }) {
    if (loading) {
      return <p>Loading...</p>;
    }

    return <Component {...props} />;
  };
}
```

HOCs are useful for sharing component behavior, although custom Hooks are often a simpler choice in modern React.

## 52\. What are custom Hooks?

Custom Hooks allow reusable stateful logic to be shared between components.

Example:

jsx

```jsx
function useUsers() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('/api/users')
      .then(res => res.json())
      .then(setUsers);
  }, []);

  return users;
}
```

Usage:

jsx

```jsx
function UserList() {
  const users = useUsers();

  return (
    <>
      {users.map(user => (
        <p key={user.id}>{user.name}</p>
      ))}
    </>
  );
}
```

## 53\. What is prop drilling?

Prop drilling means passing data through multiple intermediate components that do not need the data themselves.

Solutions:

- Context API.
- Redux.
- Component composition.
- Custom Hooks backed by shared state.
- State management libraries.

## 54\. What is hydration in React?

Hydration attaches React's event handling and behavior to HTML generated on the server.

It allows server-rendered content to become interactive in the browser.

Hydration mismatches occur when the server-rendered markup differs from the initial client-rendered output.

Common causes:

- Random values.
- Current timestamps.
- Browser-only APIs during initial rendering.
- Different server and client data.
- Locale-dependent rendering differences.

---

# PART 5: REAL-WORLD REACT SCENARIO QUESTIONS

## 55\. React application becomes slow after some time. How do you troubleshoot?

**Answer:**

I investigate:

1. Browser memory usage.
2. CPU utilization.
3. React component rendering.
4. Large DOM trees.
5. Event listeners.
6. Repeated API calls.
7. State updates.
8. Third-party libraries.

Tools:

- React Developer Tools.
- React Profiler.
- Chrome Performance.
- Chrome Memory.
- Network tab.

Possible root causes:

- Memory leaks.
- Expensive component rendering.
- Unnecessary state updates.
- Large lists.
- Excessive context updates.

I fix the actual bottleneck and validate the result through profiling.

## 56\. API is called multiple times unnecessarily. How do you solve it?

**Answer:**

Possible reasons:

- Multiple component instances.
- Effect dependency mistakes.
- Missing cleanup.
- Multiple subscriptions.
- Strict Mode development behavior.
- Repeated user interactions.

Solutions:

- Correct effect dependencies.
- Use suitable caching.
- Abort obsolete requests.
- Use a data-fetching library.
- Avoid unnecessary component remounting.

Example:

jsx

```jsx
const { data, isLoading } = useQuery({
  queryKey: ['users'],
  queryFn: getUsers
});
```

TanStack Query can provide caching, request deduplication and background refetching.

## 57\. How do you prevent duplicate form submissions?

**Answer:**

Use a loading state and disable the submit button.

jsx

```jsx
function Login() {
  const [loading, setLoading] = useState(false);

  async function submit() {
    if (loading) return;

    setLoading(true);

    try {
      await loginApi();
    } finally {
      setLoading(false);
    }
  }

  return (
    <button
      disabled={loading}
      onClick={submit}
    >
      {loading ? 'Submitting...' : 'Submit'}
    </button>
  );
}
```

For important business operations, the backend should also support idempotency.

## 58\. Search API is called on every keystroke. How do you optimize it?

**Answer:**

Use debounce and cancellation.

jsx

```jsx
useEffect(() => {
  const controller = new AbortController();

  const timer = setTimeout(async () => {
    try {
      const response = await fetch(
        `/api/search?q=${encodeURIComponent(search)}`,
        { signal: controller.signal }
      );

      const data = await response.json();

      setResults(data);
    } catch (error) {
      if (error.name !== 'AbortError') {
        console.error(error);
      }
    }
  }, 300);

  return () => {
    clearTimeout(timer);
    controller.abort();
  };
}, [search]);
```

Benefits:

- Reduces API calls.
- Cancels outdated requests.
- Improves search responsiveness.

## 59\. How do you handle authentication token expiration?

**Answer:**

I use centralized authentication and API request handling.

Typical flow:

1. API returns 401.
2. Authentication layer checks refresh eligibility.
3. Refresh token request is initiated.
4. Original request is retried when appropriate.
5. If refresh fails, user is redirected to login.

Important:

- Prevent concurrent refresh requests.
- Avoid infinite retry loops.
- Handle refresh-token expiration.
- Use secure cookie-based strategies where appropriate.
- Validate permissions on the backend.

## 60\. How do you implement role-based access control?

**Answer:**

Maintain user roles and permissions in authentication state.

Example:

jsx

```jsx
function AdminRoute({ children }) {
  const user = useAuth();

  if (!user?.roles?.includes('ADMIN')) {
    return <Navigate to="/unauthorized" />;
  }

  return children;
}
```

Important: Frontend route protection is not security enforcement. The backend must independently validate permissions.

## 61\. How do you handle global errors?

**Answer:**

React provides Error Boundaries for rendering errors.

For other errors:

- Centralized API error handling.
- Promise rejection handling where appropriate.
- Monitoring integration.
- Logging with correlation IDs.
- User-friendly error messages.

## 62\. How do you optimize a table with 100,000 records?

**Answer:**

I would avoid rendering all records in the DOM.

Solutions:

- Server-side pagination.
- Virtualization.
- Server-side sorting.
- Server-side filtering.
- Debounced search.
- Lazy loading.
- Memoized row components where beneficial.

Libraries:

- TanStack Table.
- TanStack Virtual.

## 63\. How do you handle multiple API calls in parallel?

**Answer:**

Use Promise.all when all successful results are required.

jsx

```jsx
async function loadDashboard() {
  const [users, orders, products] =
    await Promise.all([
      getUsers(),
      getOrders(),
      getProducts()
    ]);

  setDashboard({
    users,
    orders,
    products
  });
}
```

Use Promise.allSettled when individual failures should not prevent processing other successful results.

## 64\. How do you implement file upload?

**Answer:**

Use FormData.

jsx

```jsx
async function uploadFile(file) {
  const formData = new FormData();

  formData.append('file', file);

  const response = await fetch(
    '/api/upload',
    {
      method: 'POST',
      body: formData
    }
  );

  if (!response.ok) {
    throw new Error('Upload failed');
  }

  return response.json();
}
```

Important considerations:

- File size.
- File type validation.
- Upload progress.
- Cancellation.
- Backend validation.
- Secure storage.

## 65\. How do you implement real-time updates?

**Answer:**

Possible technologies:

- WebSockets.
- Server-Sent Events.
- Polling.

WebSockets support bidirectional communication.

SSE supports server-to-client streaming.

Polling periodically requests updates.

Choose according to latency, infrastructure and communication requirements.

---

# PART 6: REACT TESTING QUESTIONS

## 66\. What is unit testing in React?

**Answer:**

Unit testing validates individual components and functions.

Popular tools:

- Jest.
- Vitest.
- React Testing Library.

Example:

jsx

```jsx
import {
  render,
  screen,
  fireEvent
} from '@testing-library/react';

test('increments counter', () => {
  render(<Counter />);

  fireEvent.click(
    screen.getByText('Increment')
  );

  expect(
    screen.getByText('Count: 1')
  ).toBeInTheDocument();
});
```

## 67\. What is React Testing Library?

It is a testing library focused on testing components through user-visible behavior.

It encourages testing what users see and interact with rather than relying on component implementation details.

## 68\. Difference between unit, integration and E2E testing?

| Testing | Purpose |
| --- | --- |
| Unit | Individual components and functions |
| Integration | Interaction between multiple components |
| E2E | Complete user workflows |

Tools:

- Jest/Vitest.
- React Testing Library.
- Playwright.
- Cypress.

## 69\. How do you test API calls?

**Answer:**

Mock the API layer and verify:

1. Loading state.
2. Successful response.
3. Error response.
4. Empty response.
5. Retry behavior where applicable.

MSW (Mock Service Worker) is useful for intercepting network requests in tests.

## 70\. How do you test custom Hooks?

**Answer:**

Use React Testing Library's `renderHook` utility.

Test:

- Initial state.
- State updates.
- Returned values.
- Error behavior.
- Cleanup.

---

# PART 7: IMPORTANT REACT CODING QUESTIONS

Practice implementing these without relying on an IDE.

1. Reverse a string.
2. Find duplicate elements in an array.
3. Find the second-highest number.
4. Remove duplicate objects by ID.
5. Sort employees by salary.
6. Build a reusable React component.
7. Create a custom Hook.
8. Implement debounce.
9. Implement search autocomplete.
10. Implement pagination.
11. Create a reusable modal.
12. Implement protected routes.
13. Create a custom form validator.
14. Implement file upload.
15. Implement infinite scrolling.
16. Create a Redux Toolkit slice.
17. Implement API caching.
18. Implement a reusable data table.
19. Create a theme switcher using Context.
20. Implement a shopping cart.

### Example: Remove duplicate objects by ID

javascript

```javascript
const users = [
  { id: 1, name: 'John' },
  { id: 2, name: 'David' },
  { id: 1, name: 'John' }
];

const uniqueUsers = [
  ...new Map(
    users.map(user => [user.id, user])
  ).values()
];
```

### Example: Second-highest number

javascript

```javascript
const numbers = [10, 20, 30, 30, 40];

const unique = [...new Set(numbers)];

const secondHighest = unique
  .sort((a, b) => b - a)[1];
```

### Example: Custom debounce Hook

jsx

```jsx
function useDebounce(value, delay) {
  const [debouncedValue, setDebouncedValue] =
    useState(value);

  useEffect(() => {
    const timer = setTimeout(() => {
      setDebouncedValue(value);
    }, delay);

    return () => clearTimeout(timer);
  }, [value, delay]);

  return debouncedValue;
}
```

Usage:

jsx

```jsx
const debouncedSearch = useDebounce(search, 300);
```

---

# PART 8: FRONTEND SYSTEM DESIGN QUESTIONS

Prepare the following architecture discussions:

1. Design an enterprise React application.
2. Design an e-commerce frontend.
3. Design a dashboard with multiple widgets.
4. Design a role-based admin portal.
5. Design a reusable component library.
6. Design a real-time notification system.
7. Design a dynamic form engine.
8. Design a high-performance data table.
9. Design authentication and authorization.
10. Design a multi-tenant React application.

For every system design, explain:

- Component hierarchy.
- Feature-based folder structure.
- Routing.
- State management.
- API integration.
- Authentication.
- Error handling.
- Performance optimization.
- Accessibility.
- Testing.
- Deployment.

---

# PART 9: REACT 19 MODERN FEATURES

Senior interviews may cover these modern React concepts.

| Feature | What to understand |
| --- | --- |
| Actions | Managing asynchronous form and action workflows |
| useActionState | Managing action-related state |
| useOptimistic | Optimistic UI updates |
| useFormStatus | Accessing form submission status |
| use | Reading supported resources such as Promises and Context |
| Server Components | Server-rendered component model |
| Suspense | Rendering fallbacks while supported content is waiting |
| Transitions | Prioritizing non-urgent updates |
| Automatic batching | Grouping state updates |
| Concurrent rendering | Interruptible rendering work |
| Ref as prop | Modern ref handling in React 19 |
| Document metadata | Rendering document metadata from components |

### Example: useOptimistic

jsx

```jsx
import {
  useOptimistic,
  useState
} from 'react';

function Comments() {
  const [comments, setComments] = useState([]);

  const [optimisticComments, addOptimistic] =
    useOptimistic(
      comments,
      (state, newComment) => [
        ...state,
        newComment
      ]
    );

  async function addComment(text) {
    addOptimistic(text);

    const saved = await saveComment(text);

    setComments(current => [
      ...current,
      saved
    ]);
  }

  return (
    <div>
      {optimisticComments.map((comment, index) => (
        <p key={index}>{comment}</p>
      ))}
    </div>
  );
}
```

Optimistic state provides immediate UI feedback while an asynchronous operation is pending.

**Version note:** Some APIs and framework integrations have version-specific requirements. Check the installed React and framework versions before using them.

---

# PART 10: SEVEN-DAY REACT INTERVIEW PREPARATION PLAN

| Day | Topics |
| --- | --- |
| Day 1 | JavaScript, ES6+, TypeScript |
| Day 2 | React components, JSX, props and state |
| Day 3 | Hooks, Context API, custom Hooks |
| Day 4 | Redux Toolkit, routing and API integration |
| Day 5 | Performance, Suspense and React 19 |
| Day 6 | Testing, security and architecture |
| Day 7 | Scenario-based questions and mock interviews |

---

# PART 11: FINAL REACT INTERVIEW REVISION CHECKLIST

## React fundamentals

- [ ]Components.
- [ ]JSX.
- [ ]Props.
- [ ]State.
- [ ]Virtual DOM.
- [ ]Reconciliation.
- [ ]Keys.
- [ ]Fragments.
- [ ]Controlled components.
- [ ]Uncontrolled components.
- [ ]Error Boundaries.

## React Hooks

- [ ]useState.
- [ ]useEffect.
- [ ]useContext.
- [ ]useRef.
- [ ]useMemo.
- [ ]useCallback.
- [ ]useReducer.
- [ ]useLayoutEffect.
- [ ]useTransition.
- [ ]useDeferredValue.
- [ ]Custom Hooks.

## JavaScript and TypeScript

- [ ]var, let and const.
- [ ]Closures.
- [ ]Hoisting.
- [ ]Event loop.
- [ ]Promises.
- [ ]Async/await.
- [ ]Map, filter and reduce.
- [ ]Destructuring.
- [ ]Generics.
- [ ]Interfaces and types.

## State management

- [ ]Context API.
- [ ]Redux.
- [ ]Redux Toolkit.
- [ ]Actions.
- [ ]Reducers.
- [ ]Selectors.
- [ ]Middleware.
- [ ]RTK Query.
- [ ]TanStack Query.

## Performance

- [ ]React.memo.
- [ ]useMemo.
- [ ]useCallback.
- [ ]Lazy loading.
- [ ]Code splitting.
- [ ]Virtualization.
- [ ]Suspense.
- [ ]Memory leak detection.
- [ ]Bundle optimization.
- [ ]Concurrent rendering.

## Advanced React

- [ ]React Router.
- [ ]Higher Order Components.
- [ ]Custom Hooks.
- [ ]Error Boundaries.
- [ ]Server Components.
- [ ]SSR.
- [ ]Hydration.
- [ ]React 19 Actions.
- [ ]Optimistic UI.

## Testing and security

- [ ]Unit testing.
- [ ]Integration testing.
- [ ]E2E testing.
- [ ]React Testing Library.
- [ ]Jest/Vitest.
- [ ]Playwright/Cypress.
- [ ]XSS prevention.
- [ ]Authentication.
- [ ]Authorization.
- [ ]Secure token handling.

---

# FINAL INTERVIEW ADVICE

For a Senior React Developer interview, knowing Hooks and JSX is not enough.

Interviewers expect you to demonstrate that you can:

1. Build scalable frontend applications.
2. Design reusable component architecture.
3. Manage complex application state.
4. Handle asynchronous API operations.
5. Optimize unnecessary rendering.
6. Prevent memory leaks.
7. Build secure frontend applications.
8. Integrate with Java/Spring Boot microservices.
9. Design maintainable enterprise architecture.
10. Mentor developers and make technical decisions.

## Five topics to master

1. React Hooks and component lifecycle behavior.
2. Redux Toolkit and application state management.
3. Performance optimization and unnecessary re-renders.
4. API integration, authentication and error handling.
5. React architecture and frontend system design.

**Most important:** Prepare at least two real project examples. Explain how you designed the component architecture, managed shared state, solved a performance problem, handled API failures and improved application maintainability.

A senior developer should explain not just how a React feature works, but why a particular implementation is suitable and what alternatives were considered.

Suggested filename: `Senior_React_Developer_Interview_Preparation.md`

You can save the document using this filename and open it in VS Code or any Markdown editor.

## My recommendation for Senior Full Stack Java + React interviews

Give additional preparation time to these integration scenarios:

- React + Spring Boot REST API integration.
- JWT authentication and refresh-token handling.
- Redux Toolkit for shared state.
- TanStack Query for API caching.
- Pagination, sorting and filtering.
- React performance with large datasets.
- Role-based authorization.
- Global error handling.
- Microfrontend architecture.
- Docker and production deployment.

These topics help demonstrate senior-level practical experience rather than just theoretical React knowledge.
