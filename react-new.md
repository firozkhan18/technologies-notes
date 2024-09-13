## **Table of Contents**

| **No.** | **Questions** |
| --- | --- |
|     | **Core React** |
| 1   | [What is React?](#what-is-react) |
| 2   | [What are the major features of React?](#what-are-the-major-features-of-react) |
| 3   | [What is JSX?](#what-is-jsx) |
| 4   | [What is the difference between Element and Component?](#what-is-the-difference-between-element-and-component) |
| 5   | [How to create components in React?](#how-to-create-components-in-react) |
| 6   | [When to use a Class Component over a Function Component?](#when-to-use-a-class-component-over-a-function-component) |
| 7   | [What are Pure Components?](#what-are-pure-components) |
| 8   | [What is state in React?](#what-is-state-in-react) |
| 9   | [What are props in React?](#what-are-props-in-react) |
| 10  | [What is the difference between state and props?](#what-is-the-difference-between-state-and-props) |
| 11  | [Why should we not update the state directly?](#why-should-we-not-update-the-state-directly) |
| 12  | [What is the purpose of callback function as an argument of setState()?](#what-is-the-purpose-of-callback-function-as-an-argument-of-setstate) |
| 13  | [What is the difference between HTML and React event handling?](#what-is-the-difference-between-html-and-react-event-handling) |
| 14  | [How to bind methods or event handlers in JSX callbacks?](#how-to-bind-methods-or-event-handlers-in-jsx-callbacks) |
| 15  | [How to pass a parameter to an event handler or callback?](#how-to-pass-a-parameter-to-an-event-handler-or-callback) |
| 16  | [What are synthetic events in React?](#what-are-synthetic-events-in-react) |
| 17  | [What are inline conditional expressions?](#what-are-inline-conditional-expressions) |
| 18  | [What is "key" prop and what is the benefit of using it in arrays of elements?](#what-is-key-prop-and-what-is-the-benefit-of-using-it-in-arrays-of-elements) |
| 19  | [What is the use of refs?](#what-is-the-use-of-refs) |
| 20  | [How to create refs?](#how-to-create-refs) |
| 21  | [What are forward refs?](#what-are-forward-refs) |
| 22  | [Which is preferred option with in callback refs and findDOMNode()?](#which-is-preferred-option-with-in-callback-refs-and-finddomnode) |
| 23  | [Why are String Refs legacy?](#why-are-string-refs-legacy) |
| 24  | [What is Virtual DOM?](#what-is-virtual-dom) |
| 25  | [How Virtual DOM works?](#how-virtual-dom-works) |
| 26  | [What is the difference between Shadow DOM and Virtual DOM?](#what-is-the-difference-between-shadow-dom-and-virtual-dom) |
| 27  | [What is React Fiber?](#what-is-react-fiber) |
| 28  | [What is the main goal of React Fiber?](#what-is-the-main-goal-of-react-fiber) |
| 29  | [What are controlled components?](#what-are-controlled-components) |
| 30  | [What are uncontrolled components?](#what-are-uncontrolled-components) |
| 31  | [What is the difference between createElement and cloneElement?](#what-is-the-difference-between-createelement-and-cloneelement) |
| 32  | [What is Lifting State Up in React?](#what-is-lifting-state-up-in-react) |
| 33  | [What are the different phases of component lifecycle?](#what-are-the-different-phases-of-component-lifecycle) |
| 34  | [What are the lifecycle methods of React?](#what-are-the-lifecycle-methods-of-react) |
| 35  | [What are Higher-Order components?](#what-are-higher-order-components) |
| 36  | [How to create props proxy for HOC component?](#how-to-create-props-proxy-for-hoc-component) |
| 37  | [What is context?](#what-is-context) |
| 38  | [What is children prop?](#what-is-children-prop) |
| 39  | [How to write comments in React?](#how-to-write-comments-in-react) |
| 40  | [What is the purpose of using super constructor with props argument?](#what-is-the-purpose-of-using-super-constructor-with-props-argument) |
| 41  | [What is reconciliation?](#what-is-reconciliation) |
| 42  | [How to set state with a dynamic key name?](#how-to-set-state-with-a-dynamic-key-name) |
| 43  | [What would be the common mistake of function being called every time the component renders?](#what-would-be-the-common-mistake-of-function-being-called-every-time-the-component-renders) |
| 44  | [Is lazy function supports named exports?](#is-lazy-function-supports-named-exports) |
| 45  | [Why React uses className over class attribute?](#why-react-uses-classname-over-class-attribute) |
| 46  | [What are fragments?](#what-are-fragments) |
| 47  | [Why fragments are better than container divs?](#why-fragments-are-better-than-container-divs) |
| 48  | [What are portals in React?](#what-are-portals-in-react) |
| 49  | [What are stateless components?](#what-are-stateless-components) |
| 50  | [What are stateful components?](#what-are-stateful-components) |
| 51  | [How to apply validation on props in React?](#how-to-apply-validation-on-props-in-react) |
| 52  | [What are the advantages of React?](#what-are-the-advantages-of-react) |
| 53  | [What are the limitations of React?](#what-are-the-limitations-of-react) |
| 54  | [What are error boundaries in React v16](#what-are-error-boundaries-in-react-v16) |
| 55  | [How error boundaries handled in React v15?](#how-error-boundaries-handled-in-react-v15) |
| 56  | [What are the recommended ways for static type checking?](#what-are-the-recommended-ways-for-static-type-checking) |
| 57  | [What is the use of react-dom package?](#what-is-the-use-of-react-dom-package) |
| 58  | [What is the purpose of render method of react-dom?](#what-is-the-purpose-of-render-method-of-react-dom) |
| 59  | [What is ReactDOMServer?](#what-is-reactdomserver) |
| 60  | [How to use InnerHtml in React?](#how-to-use-innerhtml-in-react) |
| 61  | [How to use styles in React?](#how-to-use-styles-in-react) |
| 62  | [How events are different in React?](#how-events-are-different-in-react) |
| 63  | [What will happen if you use setState in constructor?](#what-will-happen-if-you-use-setstate-in-constructor) |
| 64  | [What is the impact of indexes as keys?](#what-is-the-impact-of-indexes-as-keys) |
| 65  | [Is it good to use setState() in componentWillMount() method?](#is-it-good-to-use-setstate-in-componentwillmount-method) |
| 66  | [What will happen if you use props in initial state?](#what-will-happen-if-you-use-props-in-initial-state) |
| 67  | [How do you conditionally render components?](#how-do-you-conditionally-render-components) |
| 68  | [Why we need to be careful when spreading props on DOM elements??](#why-we-need-to-be-careful-when-spreading-props-on-dom-elements) |
| 69  | [How you use decorators in React?](#how-you-use-decorators-in-react) |
| 70  | [How do you memoize a component?](#how-do-you-memoize-a-component) |
| 71  | [How you implement Server-Side Rendering or SSR?](#how-you-implement-server-side-rendering-or-ssr) |
| 72  | [How to enable production mode in React?](#how-to-enable-production-mode-in-react) |
| 73  | [What is CRA and its benefits?](#what-is-cra-and-its-benefits) |
| 74  | [What is the lifecycle methods order in mounting?](#what-is-the-lifecycle-methods-order-in-mounting) |
| 75  | [What are the lifecycle methods going to be deprecated in React v16?](#what-are-the-lifecycle-methods-going-to-be-deprecated-in-react-v16) |
| 76  | [What is the purpose of getDerivedStateFromProps() lifecycle method?](#what-is-the-purpose-of-getderivedstatefromprops-lifecycle-method) |
| 77  | [What is the purpose of getSnapshotBeforeUpdate() lifecycle method?](#what-is-the-purpose-of-getsnapshotbeforeupdate-lifecycle-method) |
| 78  | [Do Hooks replace render props and higher order components?](#do-hooks-replace-render-props-and-higher-order-components) |
| 79  | [What is the recommended way for naming components?](#what-is-the-recommended-way-for-naming-components) |
| 80  | [What is the recommended ordering of methods in component class?](#what-is-the-recommended-ordering-of-methods-in-component-class) |
| 81  | [What is a switching component?](#what-is-a-switching-component) |
| 82  | [Why we need to pass a function to setState()?](#why-we-need-to-pass-a-function-to-setstate) |
| 83  | [What is strict mode in React?](#what-is-strict-mode-in-react) |
| 84  | [What are React Mixins?](#what-are-react-mixins) |
| 85  | [Why is isMounted() an anti-pattern and what is the proper solution?](#why-is-ismounted-an-anti-pattern-and-what-is-the-proper-solution) |
| 86  | [What are the Pointer Events supported in React?](#what-are-the-pointer-events-supported-in-react) |
| 87  | [Why should component names start with capital letter?](#why-should-component-names-start-with-capital-letter) |
| 88  | [Are custom DOM attributes supported in React v16?](#are-custom-dom-attributes-supported-in-react-v16) |
| 89  | [What is the difference between constructor and getInitialState?](#what-is-the-difference-between-constructor-and-getinitialstate) |
| 90  | [Can you force a component to re-render without calling setState?](#can-you-force-a-component-to-re-render-without-calling-setstate) |
| 91  | [What is the difference between super() and super(props) in React using ES6 classes?](#what-is-the-difference-between-super-and-superprops-in-react-using-es6-classes) |
| 92  | [How to loop inside JSX?](#how-to-loop-inside-jsx) |
| 93  | [How do you access props in attribute quotes?](#how-do-you-access-props-in-attribute-quotes) |
| 94  | [What is React PropType array with shape?](#what-is-react-proptype-array-with-shape) |
| 95  | [How to conditionally apply class attributes?](#how-to-conditionally-apply-class-attributes) |
| 96  | [What is the difference between React and ReactDOM?](#what-is-the-difference-between-react-and-reactdom) |
| 97  | [Why ReactDOM is separated from React?](#why-reactdom-is-separated-from-react) |
| 98  | [How to use React label element?](#how-to-use-react-label-element) |
| 99  | [How to combine multiple inline style objects?](#how-to-combine-multiple-inline-style-objects) |
| 100 | [How to re-render the view when the browser is resized?](#how-to-re-render-the-view-when-the-browser-is-resized) |
| 101 | [What is the difference between setState and replaceState methods?](#what-is-the-difference-between-setstate-and-replacestate-methods) |
| 102 | [How to listen to state changes?](#how-to-listen-to-state-changes) |
| 103 | [What is the recommended approach of removing an array element in react state?](#what-is-the-recommended-approach-of-removing-an-array-element-in-react-state) |
| 104 | [Is it possible to use React without rendering HTML?](#is-it-possible-to-use-react-without-rendering-html) |
| 105 | [How to pretty print JSON with React?](#how-to-pretty-print-json-with-react) |
| 106 | [Why you can't update props in React?](#why-you-cant-update-props-in-react) |
| 107 | [How to focus an input element on page load?](#how-to-focus-an-input-element-on-page-load) |
| 108 | [What are the possible ways of updating objects in state?](#what-are-the-possible-ways-of-updating-objects-in-state) |
| 110 | [How can we find the version of React at runtime in the browser?](#how-can-we-find-the-version-of-react-at-runtime-in-the-browser) |
| 111 | [What are the approaches to include polyfills in your create-react-app?](#what-are-the-approaches-to-include-polyfills-in-your-create-react-app) |
| 112 | [How to use https instead of http in create-react-app?](#how-to-use-https-instead-of-http-in-create-react-app) |
| 113 | [How to avoid using relative path imports in create-react-app?](#how-to-avoid-using-relative-path-imports-in-create-react-app) |
| 114 | [How to add Google Analytics for react-router?](#how-to-add-google-analytics-for-react-router) |
| 115 | [How to update a component every second?](#how-to-update-a-component-every-second) |
| 116 | [How do you apply vendor prefixes to inline styles in React?](#how-do-you-apply-vendor-prefixes-to-inline-styles-in-react) |
| 117 | [How to import and export components using react and ES6?](#how-to-import-and-export-components-using-react-and-es6) |
| 118 | [What are the exceptions on React component naming?](#what-are-the-exceptions-on-react-component-naming) |
| 119 | [Why is a component constructor called only once?](#why-is-a-component-constructor-called-only-once) |
| 120 | [How to define constants in React?](#how-to-define-constants-in-react) |
| 121 | [How to programmatically trigger click event in React?](#how-to-programmatically-trigger-click-event-in-react) |
| 122 | [Is it possible to use async/await in plain React?](#is-it-possible-to-use-asyncawait-in-plain-react) |
| 123 | [What are the common folder structures for React?](#what-are-the-common-folder-structures-for-react) |
| 124 | [What are the popular packages for animation?](#what-are-the-popular-packages-for-animation) |
| 125 | [What is the benefit of styles modules?](#what-is-the-benefit-of-styles-modules) |
| 126 | [What are the popular React-specific linters?](#what-are-the-popular-react-specific-linters) |
| 127 | [How to make AJAX call and In which component lifecycle methods should I make an AJAX call?](#how-to-make-ajax-call-and-in-which-component-lifecycle-methods-should-i-make-an-ajax-call) |
| 128 | [What are render props?](#what-are-render-props) |
|     | **React Router** |
| 129 | [What is React Router?](#what-is-react-router) |
| 130 | [How React Router is different from history library?](#how-react-router-is-different-from-history-library) |
| 131 | [What are the <Router> components of React Router v4?](#what-are-the-router-components-of-react-router-v4) |
| 132 | [What is the purpose of push and replace methods of history?](#what-is-the-purpose-of-push-and-replace-methods-of-history) |
| 133 | [How do you programmatically navigate using React router v4?](#how-do-you-programmatically-navigate-using-react-router-v4) |
| 134 | [How to get query parameters in React Router v4](#how-to-get-query-parameters-in-react-router-v4) |
| 135 | [Why you get "Router may have only one child element" warning?](#why-you-get-router-may-have-only-one-child-element-warning) |
| 136 | [How to pass params to history.push method in React Router v4?](#how-to-pass-params-to-historypush-method-in-react-router-v4) |
| 137 | [How to implement default or NotFound page?](#how-to-implement-default-or-notfound-page) |
| 138 | [How to get history on React Router v4?](#how-to-get-history-on-react-router-v4) |
| 139 | [How to perform automatic redirect after login?](#how-to-perform-automatic-redirect-after-login) |
|     | **React Internationalization** |
| 140 | [What is React-Intl?](#what-is-react-intl) |
| 141 | [What are the main features of React Intl?](#what-are-the-main-features-of-react-intl) |
| 142 | [What are the two ways of formatting in React Intl?](#what-are-the-two-ways-of-formatting-in-react-intl) |
| 143 | [How to use FormattedMessage as placeholder using React Intl?](#how-to-use-formattedmessage-as-placeholder-using-react-intl) |
| 144 | [How to access current locale with React Intl](#how-to-access-current-locale-with-react-intl) |
| 145 | [How to format date using React Intl?](#how-to-format-date-using-react-intl) |
|     | **React Testing** |
| 146 | [What is Shallow Renderer in React testing?](#what-is-shallow-renderer-in-react-testing) |
| 147 | [What is TestRenderer package in React?](#what-is-testrenderer-package-in-react) |
| 148 | [What is the purpose of ReactTestUtils package?](#what-is-the-purpose-of-reacttestutils-package) |
| 149 | [What is Jest?](#what-is-jest) |
| 150 | [What are the advantages of Jest over Jasmine?](#what-are-the-advantages-of-jest-over-jasmine) |
| 151 | [Give a simple example of Jest test case](#give-a-simple-example-of-jest-test-case) |
|     | **React Redux** |
| 152 | [What is Flux?](#what-is-flux) |
| 153 | [What is Redux?](#what-is-redux) |
| 154 | [What are the core principles of Redux?](#what-are-the-core-principles-of-redux) |
| 155 | [What are the downsides of Redux compared to Flux?](#what-are-the-downsides-of-redux-compared-to-flux) |
| 156 | [What is the difference between mapStateToProps() and mapDispatchToProps()?](#what-is-the-difference-between-mapstatetoprops-and-mapdispatchtoprops) |
| 157 | [Can I dispatch an action in reducer?](#can-i-dispatch-an-action-in-reducer) |
| 158 | [How to access Redux store outside a component?](#how-to-access-redux-store-outside-a-component) |
| 159 | [What are the drawbacks of MVW pattern](#what-are-the-drawbacks-of-mvw-pattern) |
| 160 | [Are there any similarities between Redux and RxJS?](#are-there-any-similarities-between-redux-and-rxjs) |
| 161 | [How to dispatch an action on load?](#how-to-dispatch-an-action-on-load) |
| 162 | [How to use connect from React Redux?](#how-to-use-connect-from-react-redux) |
| 163 | [How to reset state in Redux?](#how-to-reset-state-in-redux) |
| 164 | [Whats the purpose of at symbol in the redux connect decorator?](#whats-the-purpose-of-at-symbol-in-the-redux-connect-decorator) |
| 165 | [What is the difference between React context and React Redux?](#what-is-the-difference-between-react-context-and-react-redux) |
| 166 | [Why are Redux state functions called reducers?](#why-are-redux-state-functions-called-reducers) |
| 167 | [How to make AJAX request in Redux?](#how-to-make-ajax-request-in-redux) |
| 168 | [Should I keep all component's state in Redux store?](#should-i-keep-all-components-state-in-redux-store) |
| 169 | [What is the proper way to access Redux store?](#what-is-the-proper-way-to-access-redux-store) |
| 170 | [What is the difference between component and container in React Redux?](#what-is-the-difference-between-component-and-container-in-react-redux) |
| 171 | [What is the purpose of the constants in Redux?](#what-is-the-purpose-of-the-constants-in-redux) |
| 172 | [What are the different ways to write mapDispatchToProps()?](#what-are-the-different-ways-to-write-mapdispatchtoprops) |
| 173 | [What is the use of the ownProps parameter in mapStateToProps() and mapDispatchToProps()?](#what-is-the-use-of-the-ownprops-parameter-in-mapstatetoprops-and-mapdispatchtoprops) |
| 174 | [How to structure Redux top level directories?](#how-to-structure-redux-top-level-directories) |
| 175 | [What is redux-saga?](#what-is-redux-saga) |
| 176 | [What is the mental model of redux-saga?](#what-is-the-mental-model-of-redux-saga) |
| 177 | [What are the differences between call and put in redux-saga](#what-are-the-differences-between-call-and-put-in-redux-saga) |
| 178 | [What is Redux Thunk?](#what-is-redux-thunk) |
| 179 | [What are the differences between redux-saga and redux-thunk](#what-are-the-differences-between-redux-saga-and-redux-thunk) |
| 180 | [What is Redux DevTools?](#what-is-redux-devtools) |
| 181 | [What are the features of Redux DevTools?](#what-are-the-features-of-redux-devtools) |
| 182 | [What are Redux selectors and Why to use them?](#what-are-redux-selectors-and-why-to-use-them) |
| 183 | [What is Redux Form?](#what-is-redux-form) |
| 184 | [What are the main features of Redux Form?](#what-are-the-main-features-of-redux-form) |
| 185 | [How to add multiple middlewares to Redux?](#how-to-add-multiple-middlewares-to-redux) |
| 186 | [How to set initial state in Redux?](#how-to-set-initial-state-in-redux) |
| 187 | [How Relay is different from Redux?](#how-relay-is-different-from-redux) |
| 188 | [What is an action in Redux?](#what-is-an-action-in-redux) |
|     | **React Native** |
| 188 | [What is the difference between React Native and React?](#what-is-the-difference-between-react-native-and-react) |
| 189 | [How to test React Native apps?](#how-to-test-react-native-apps) |
| 190 | [How to do logging in React Native?](#how-to-do-logging-in-react-native) |
| 191 | [How to debug your React Native?](#how-to-debug-your-react-native) |
|     | **React supported libraries and Integration** |
| 192 | [What is reselect and how it works?](#what-is-reselect-and-how-it-works) |
| 193 | [What is Flow?](#what-is-flow) |
| 194 | [What is the difference between Flow and PropTypes?](#what-is-the-difference-between-flow-and-proptypes) |
| 195 | [How to use font-awesome icons in React?](#how-to-use-font-awesome-icons-in-react) |
| 196 | [What is React Dev Tools?](#what-is-react-dev-tools) |
| 197 | [Why is DevTools not loading in Chrome for local files?](#why-is-devtools-not-loading-in-chrome-for-local-files) |
| 198 | [How to use Polymer in React?](#how-to-use-polymer-in-react) |
| 199 | [What are the advantages of React over Vue.js?](#what-are-the-advantages-of-react-over-vuejs) |
| 200 | [What is the difference between React and Angular?](#what-is-the-difference-between-react-and-angular) |
| 201 | [Why React tab is not showing up in DevTools?](#why-react-tab-is-not-showing-up-in-devtools) |
| 202 | [What are styled components?](#what-are-styled-components) |
| 203 | [Give an example of Styled Components?](#give-an-example-of-styled-components) |
| 204 | [What is Relay?](#what-is-relay) |
| 205 | [How to use TypeScript in create-react-app application?](#how-to-use-typescript-in-create-react-app-application) |
|     | **Miscellaneous** |
| 206 | [What are the main features of reselect library?](#what-are-the-main-features-of-reselect-library) |
| 207 | [Give an example of reselect usage?](#give-an-example-of-reselect-usage) |
| 209 | [Does the statics object work with ES6 classes in React?](#does-the-statics-object-work-with-es6-classes-in-react) |
| 210 | [Can Redux only be used with React?](#can-redux-only-be-used-with-react) |
| 211 | [Do you need to have a particular build tool to use Redux?](#do-you-need-to-have-a-particular-build-tool-to-use-redux) |
| 212 | [How Redux Form initialValues get updated from state?](#how-redux-form-initialvalues-get-updated-from-state) |
| 213 | [How React PropTypes allow different type for one prop?](#how-react-proptypes-allow-different-types-for-one-prop) |
| 214 | [Can I import an SVG file as react component?](#can-i-import-an-svg-file-as-react-component) |
| 215 | [Why are inline ref callbacks or functions not recommended?](#why-are-inline-ref-callbacks-or-functions-not-recommended) |
| 216 | [What is render hijacking in React?](#what-is-render-hijacking-in-react) |
| 217 | [What are HOC factory implementations?](#what-are-hoc-factory-implementations) |
| 218 | [How to pass numbers to React component?](#how-to-pass-numbers-to-react-component) |
| 219 | [Do I need to keep all my state into Redux? Should I ever use react internal state?](#do-i-need-to-keep-all-my-state-into-redux-should-i-ever-use-react-internal-state) |
| 220 | [What is the purpose of registerServiceWorker in React?](#what-is-the-purpose-of-registerserviceworker-in-react) |
| 221 | [What is React memo function?](#what-is-react-memo-function) |
| 222 | [What is React lazy function?](#what-is-react-lazy-function) |
| 223 | [How to prevent unnecessary updates using setState?](#how-to-prevent-unnecessary-updates-using-setstate) |
| 224 | [How do you render Array, Strings and Numbers in React 16 Version?](#how-do-you-render-array-strings-and-numbers-in-react-16-version) |
| 225 | [How to use class field declarations syntax in React classes?](#how-to-use-class-field-declarations-syntax-in-react-classes) |
| 226 | [What are hooks?](#what-are-hooks) |
| 227 | [What are the rules needs to follow for hooks?](#what-are-the-rules-needs-to-follow-for-hooks) |
| 228 | [How to ensure hooks followed the rules in your project?](#how-to-ensure-hooks-followed-the-rules-in-your-project) |
| 229 | [What are the differences between Flux and Redux?](#what-are-the-differences-between-flux-and-redux) |
| 230 | [What are the benefits of React Router V4?](#what-are-the-benefits-of-react-router-v4) |
| 231 | [Can you describe about componentDidCatch lifecycle method signature?](#can-you-describe-about-componentdidcatch-lifecycle-method-signature) |
| 232 | [In which scenarios error boundaries do not catch errors?](#in-which-scenarios-error-boundaries-do-not-catch-errors) |
| 233 | [Why do not you need error boundaries for event handlers?](#why-do-not-you-need-error-boundaries-for-event-handlers) |
| 234 | [What is the difference between try catch block and error boundaries?](#what-is-the-difference-between-try-catch-block-and-error-boundaries) |
| 235 | [What is the behavior of uncaught errors in react 16?](#what-is-the-behavior-of-uncaught-errors-in-react-16) |
| 236 | [What is the proper placement for error boundaries?](#what-is-the-proper-placement-for-error-boundaries) |
| 237 | [What is the benefit of component stack trace from error boundary?](#what-is-the-benefit-of-component-stack-trace-from-error-boundary) |
| 238 | [What is the required method to be defined for a class component?](#what-is-the-required-method-to-be-defined-for-a-class-component) |
| 239 | [What are the possible return types of render method?](#what-are-the-possible-return-types-of-render-method) |
| 240 | [What is the main purpose of constructor?](#what-is-the-main-purpose-of-constructor) |
| 241 | [Is it mandatory to define constructor for React component?](#is-it-mandatory-to-define-constructor-for-react-component) |
| 242 | [What are default props?](#what-are-default-props) |
| 243 | [Why should not call setState in componentWillUnmount?](#why-should-not-call-setstate-in-componentwillunmount) |
| 244 | [What is the purpose of getDerivedStateFromError?](#what-is-the-purpose-of-getderivedstatefromerror) |
| 245 | [What is the methods order when component re-rendered?](#what-is-the-methods-order-when-component-re-rendered) |
| 246 | [What are the methods invoked during error handling?](#what-are-the-methods-invoked-during-error-handling) |
| 247 | [What is the purpose of displayName class property?](#what-is-the-purpose-of-displayname-class-property) |
| 248 | [What is the browser support for react applications?](#what-is-the-browser-support-for-react-applications) |
| 249 | [What is the purpose of unmountComponentAtNode method?](#what-is-the-purpose-of-unmountcomponentatnode-method) |
| 250 | [What is code-splitting?](#what-is-code-splitting) |
| 251 | [What is the benefit of strict mode?](#what-is-the-benefit-of-strict-mode) |
| 252 | [What are Keyed Fragments?](#what-are-keyed-fragments) |
| 253 | [Does React support all HTML attributes?](#does-react-support-all-html-attributes) |
| 254 | [What are the limitations with HOCs?](#what-are-the-limitations-with-hocs) |
| 255 | [How to debug forwardRefs in DevTools?](#how-to-debug-forwardrefs-in-devtools) |
| 256 | [When component props defaults to true?](#when-component-props-defaults-to-true) |
| 257 | [What is NextJS and major features of it?](#what-is-nextjs-and-major-features-of-it) |
| 258 | [How do you pass an event handler to a component?](#how-do-you-pass-an-event-handler-to-a-component) |
| 259 | [Is it good to use arrow functions in render methods?](#is-it-good-to-use-arrow-functions-in-render-methods) |
| 260 | [How to prevent a function from being called multiple times?](#how-to-prevent-a-function-from-being-called-multiple-times) |
| 261 | [How JSX prevents Injection Attacks?](#how-jsx-prevents-injection-attacks) |
| 262 | [How do you update rendered elements?](#how-do-you-update-rendered-elements) |
| 263 | [How do you say that props are read only?](#how-do-you-say-that-props-are-read-only) |
| 264 | [How do you say that state updates are merged?](#how-do-you-say-that-state-updates-are-merged) |
| 265 | [How do you pass arguments to an event handler?](#how-do-you-pass-arguments-to-an-event-handler) |
| 266 | [How to prevent component from rendering?](#how-to-prevent-component-from-rendering) |
| 267 | [What are the conditions to safely use the index as a key?](#what-are-the-conditions-to-safely-use-the-index-as-a-key) |
| 268 | [Is it keys should be globally unique?](#is-it-keys-should-be-globally-unique) |
| 269 | [What is the popular choice for form handling?](#what-is-the-popular-choice-for-form-handling) |
| 270 | [What are the advantages of formik over redux form library?](#what-are-the-advantages-of-formik-over-redux-form-library) |
| 271 | [Why do you not required to use inheritance?](#why-do-you-not-required-to-use-inheritance) |
| 272 | [Can I use web components in react application?](#can-i-use-web-components-in-react-application) |
| 273 | [What is dynamic import?](#what-is-dynamic-import) |
| 274 | [What are loadable components?](#what-are-loadable-components) |
| 275 | [What is suspense component?](#what-is-suspense-component) |
| 276 | [What is route based code splitting?](#what-is-route-based-code-splitting) |
| 277 | [Give an example on How to use context?](#give-an-example-on-how-to-use-context) |
| 278 | [What is the purpose of default value in context?](#what-is-the-purpose-of-default-value-in-context) |
| 279 | [How do you use contextType?](#how-do-you-use-contexttype) |
| 280 | [What is a consumer?](#what-is-a-consumer) |
| 281 | [How do you solve performance corner cases while using context?](#how-do-you-solve-performance-corner-cases-while-using-context) |
| 282 | [What is the purpose of forward ref in HOCs?](#what-is-the-purpose-of-forward-ref-in-hocs) |
| 283 | [Is it ref argument available for all functions or class components?](#is-it-ref-argument-available-for-all-functions-or-class-components) |
| 284 | [Why do you need additional care for component libraries while using forward refs?](#why-do-you-need-additional-care-for-component-libraries-while-using-forward-refs) |
| 285 | [How to create react class components without ES6?](#how-to-create-react-class-components-without-es6) |
| 286 | [Is it possible to use react without JSX?](#is-it-possible-to-use-react-without-jsx) |
| 287 | [What is diffing algorithm?](#what-is-diffing-algorithm) |
| 288 | [What are the rules covered by diffing algorithm?](#what-are-the-rules-covered-by-diffing-algorithm) |
| 289 | [When do you need to use refs?](#when-do-you-need-to-use-refs) |
| 290 | [Is it prop must be named as render for render props?](#is-it-prop-must-be-named-as-render-for-render-props) |
| 291 | [What are the problems of using render props with pure components?](#what-are-the-problems-of-using-render-props-with-pure-components) |
| 292 | [How do you create HOC using render props?](#how-do-you-create-hoc-using-render-props) |
| 293 | [What is windowing technique?](#what-is-windowing-technique) |
| 294 | [How do you print falsy values in JSX?](#how-do-you-print-falsy-values-in-jsx) |
| 295 | [What is the typical use case of portals?](#what-is-the-typical-use-case-of-portals?) |
| 296 | [How do you set default value for uncontrolled component?](#how-do-you-set-default-value-for-uncontrolled-component) |
| 297 | [What is your favorite React stack?](#what-is-your-favorite-react-stack) |
| 298 | [What is the difference between Real DOM and Virtual DOM?](#what-is-the-difference-between-real-dom-and-virtual-dom) |
| 299 | [How to add Bootstrap to a react application?](#how-to-add-bootstrap-to-a-react-application) |
| 300 | [Can you list down top websites or applications using react as front end framework?](#can-you-list-down-top-websites-or-applications-using-react-as-front-end-framework) |
| 301 | [Is it recommended to use CSS In JS technique in React?](#is-it-recommended-to-use-css-in-js-technique-in-react) |
| 302 | [Do I need to rewrite all my class components with hooks?](#do-i-need-to-rewrite-all-my-class-components-with-hooks) |
| 303 | [How to fetch data with React Hooks?](#how-to-fetch-data-with-react-hooks) |
| 304 | [Is Hooks cover all use cases for classes?](#is-hooks-cover-all-use-cases-for-classes) |
| 305 | [What is the stable release for hooks support?](#what-is-the-stable-release-for-hooks-support) |
| 306 | [Why do we use array destructuring (square brackets notation) in useState?](#why-do-we-use-array-destructuring-square-brackets-notation-in-usestate) |
| 307 | [What are the sources used for introducing hooks?](#what-are-the-sources-used-for-introducing-hooks) |
| 308 | [How do you access imperative API of web components?](#how-do-you-access-imperative-api-of-web-components) |
| 309 | [What is formik?](#what-is-formik) |
| 310 | [What are typical middleware choices for handling asynchronous calls in Redux?](#what-are-typical-middleware-choices-for-handling-asynchronous-calls-in-redux) |
| 311 | [Do browsers understand JSX code?](#do-browsers-understand-jsx-code) |
| 312 | [Describe about data flow in react?](#describe-about-data-flow-in-react) |
| 313 | [What is react scripts?](#what-is-react-scripts) |
| 314 | [What are the features of create react app?](#what-are-the-features-of-create-react-app) |
| 315 | [What is the purpose of renderToNodeStream method?](#what-is-the-purpose-of-rendertonodestream-method) |
| 316 | [What is MobX?](#what-is-mobx) |
| 317 | [What are the differences between Redux and MobX?](#what-are-the-differences-between-redux-and-mobx) |
| 318 | [Should I learn ES6 before learning ReactJS?](#should-i-learn-es6-before-learning-reactjs) |
| 319 | [What is Concurrent Rendering?](#what-is-concurrent-rendering) |
| 320 | [What is the difference between async mode and concurrent mode?](#what-is-the-difference-between-async-mode-and-concurrent-mode) |
| 321 | [Can I use javascript urls in react16.9?](#can-i-use-javascript-urls-in-react169) |
| 322 | [What is the purpose of eslint plugin for hooks?](#what-is-the-purpose-of-eslint-plugin-for-hooks) |
| 323 | [What is the difference between Imperative and Declarative in React?](#what-is-the-difference-between-imperative-and-declarative-in-react) |
| 324 | [What are the benefits of using typescript with reactjs?](#what-are-the-benefits-of-using-typescript-with-reactjs) |
| 325 | [How do you make sure that user remains authenticated on page refresh while using Context API State Management?](#how-do-you-make-sure-that-user-remains-authenticated-on-page-refresh-while-using-context-api-state-management) |
| 326 | [What are the benefits of new JSX transform?](#what-are-the-benefits-of-new-jsx-transform) |
| 327 | [How does new JSX transform different from old transform?](#how-does-new-jsx-transform-different-from-old-transform) |

**Core React**

### **What is React?**

React is an **open-source frontend JavaScript library** which is used for building user interfaces especially for single page applications. It is used for handling view layer for web and mobile apps. React was created by [Jordan Walke](https://github.com/jordwalke), a software engineer working for Facebook. React was first deployed on Facebook's News Feed in 2011 and on Instagram in 2012.

[**⬆ Back to Top**](#table-of-contents)

### **What are the major features of React?**

The major features of React are:

- It uses **VirtualDOM** instead of RealDOM considering that RealDOM manipulations are expensive.
- Supports **server-side rendering**.
- Follows **Unidirectional** data flow or data binding.
- Uses **reusable/composable** UI components to develop the view.

[**⬆ Back to Top**](#table-of-contents)

### **What is JSX?**

JSX is a XML-like syntax extension to ECMAScript (the acronym stands for JavaScript XML). Basically it just provides syntactic sugar for the React.createElement() function, giving us expressiveness of JavaScript along with HTML like template syntax.

In the example below text inside `<h1>` tag is returned as JavaScript function to the render function.

```jsx
class App extends React.Component {

render() {

return (

<div>

<h1>{'Welcome to React world!'}</h1>

</div>

);

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between Element and Component?**

An _Element_ is a plain object describing what you want to appear on the screen in terms of the DOM nodes or other components. _Elements_ can contain other _Elements_ in their props. Creating a React element is cheap. Once an element is created, it is never mutated.

The object representation of React Element would be as follows:
```jsx
const element = React.createElement('div', { id: 'login-btn' }, 'Login');
```
The above React.createElement() function returns an object:
```jsx
{

type: 'div',

props: {

children: 'Login',

id: 'login-btn'

}

}
```
And finally it renders to the DOM using ReactDOM.render():
```jsx
<div id="login-btn">Login</div>
```
Whereas a **component** can be declared in several different ways. It can be a class with a render() method. Alternatively, in simple cases, it can be defined as a function. In either case, it takes props as an input, and returns a JSX tree as the output:
```jsx
const Button = ({ onLogin }) => (

<div id={'login-btn'} onClick={onLogin}>

Login

</div>

);
```
Then JSX gets transpiled to a React.createElement() function tree:
```jsx
const Button = ({ onLogin }) =>

React.createElement('div', { id: 'login-btn', onClick: onLogin }, 'Login');
```
[**⬆ Back to Top**](#table-of-contents)

### **How to create components in React?**

There are two possible ways to create a component.

1. **Function Components:** This is the simplest way to create a component. Those are pure JavaScript functions that accept props object as first parameter and return React elements:
```jsx
function Greeting({ message }) {

return <h1>{\`Hello, ${message}\`}</h1>;

}
```
1. **Class Components:** You can also use ES6 class to define a component. The above function component can be written as:
```jsx
class Greeting extends React.Component {

render() {

return <h1>{\`Hello, ${this.props.message}\`}</h1>;

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **When to use a Class Component over a Function Component?**

If the component needs _state or lifecycle methods_ then use class component otherwise use function component. _However, from React 16.8 with the addition of Hooks, you could use state , lifecycle methods and other features that were only available in class component right in your function component._

[**⬆ Back to Top**](#table-of-contents)

### **What are Pure Components?**

_React.PureComponent_ is exactly the same as _React.Component_ except that it handles the shouldComponentUpdate() method for you. When props or state changes, _PureComponent_ will do a shallow comparison on both props and state. _Component_ on the other hand won't compare current props and state to next out of the box. Thus, the component will re-render by default whenever shouldComponentUpdate is called.

[**⬆ Back to Top**](#table-of-contents)

### **What is state in React?**

_State_ of a component is an object that holds some information that may change over the lifetime of the component. We should always try to make our state as simple as possible and minimize the number of stateful components.

Let's create an user component with message state,
```jsx
class User extends React.Component {

constructor(props) {

super(props);

this.state = {

message: 'Welcome to React world',

};

}

render() {

return (

<div>

<h1>{this.state.message}</h1>

</div>

);

}

}
````
![state](data:image/jpeg;base64,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)

State is similar to props, but it is private and fully controlled by the component. i.e, It is not accessible to any component other than the one that owns and sets it.

[**⬆ Back to Top**](#table-of-contents)

### **What are props in React?**

_Props_ are inputs to components. They are single values or objects containing a set of values that are passed to components on creation using a naming convention similar to HTML-tag attributes. They are data passed down from a parent component to a child component.

The primary purpose of props in React is to provide following component functionality:

1. Pass custom data to your component.
2. Trigger state changes.
3. Use via this.props.reactProp inside component's render() method.

For example, let us create an element with reactProp property:
```jsx
<Element reactProp={'1'} />
```
This reactProp (or whatever you came up with) name then becomes a property attached to React's native props object which originally already exists on all components created using React library.
```jsx
props.reactProp
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between state and props?**

Both _props_ and _state_ are plain JavaScript objects. While both of them hold information that influences the output of render, they are different in their functionality with respect to component. Props get passed to the component similar to function parameters whereas state is managed within the component similar to variables declared within a function.

[**⬆ Back to Top**](#table-of-contents)

### **Why should we not update the state directly?**

If you try to update state directly then it won't re-render the component.

//Wrong
```jsx
this.state.message = 'Hello world';
````
Instead use setState() method. It schedules an update to a component's state object. When state changes, the component responds by re-rendering.

//Correct
```jsx
this.setState({ message: 'Hello World' });
```
**Note:** You can directly assign to the state object either in _constructor_ or using latest javascript's class field declaration syntax.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of callback function as an argument of setState()?**

The callback function is invoked when setState finished and the component gets rendered. Since setState() is **asynchronous** the callback function is used for any post action.

**Note:** It is recommended to use lifecycle method rather than this callback function.
```jsx
setState({ name: 'John' }, () => console.log('The name has updated and component re-rendered'));
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between HTML and React event handling?**

Below are some of the main differences between HTML and React event handling,

1. In HTML, the event name should be in _lowercase_:
```jsx
<button onclick="activateLasers()"></button>
```
Whereas in React it follows _camelCase_ convention:
```jsx
<button onClick={activateLasers}>
```
1. In HTML, you can return false to prevent default behavior:
```jsx
<a href="#" onclick='console.log("The link was clicked."); return false;' />
```
Whereas in React you must call preventDefault() explicitly:
```jsx
function handleClick(event) {

event.preventDefault();

console.log('The link was clicked.');

}
```
1. In HTML, you need to invoke the function by appending () Whereas in react you should not append () with the function name. (refer "activateLasers" function in the first point for example)

[**⬆ Back to Top**](#table-of-contents)

### **How to bind methods or event handlers in JSX callbacks?**

There are 3 possible ways to achieve this:

1. **Binding in Constructor:** In JavaScript classes, the methods are not bound by default. The same thing applies for React event handlers defined as class methods. Normally we bind them in constructor.
```jsx
class Component extends React.Component {

constructor(props) {

super(props);

this.handleClick = this.handleClick.bind(this);

}

handleClick() {

// ...

}

}
```
1. **Public class fields syntax:** If you don't like to use bind approach then _public class fields syntax_ can be used to correctly bind callbacks.
```jsx
handleClick = () => {

console.log('this is:', this);

};

<button onClick={this.handleClick}>{'Click me'}</button>
```
1. **Arrow functions in callbacks:** You can use _arrow functions_ directly in the callbacks.
```jsx
<button onClick={(event) => this.handleClick(event)}>{'Click me'}</button>
```
**Note:** If the callback is passed as prop to child components, those components might do an extra re-rendering. In those cases, it is preferred to go with .bind() or _public class fields syntax_ approach considering performance.

[**⬆ Back to Top**](#table-of-contents)

### **How to pass a parameter to an event handler or callback?**

You can use an _arrow function_ to wrap around an _event handler_ and pass parameters:
```jsx
<button onClick={() => this.handleClick(id)} />
```
This is an equivalent to calling .bind:
```jsx
<button onClick={this.handleClick.bind(this, id)} />
```
Apart from these two approaches, you can also pass arguments to a function which is defined as arrow function
```jsx
<button onClick={this.handleClick(id)} />;

handleClick = (id) => () => {

console.log('Hello, your ticket number is', id);

};
```
[**⬆ Back to Top**](#table-of-contents)

### **What are synthetic events in React?**

SyntheticEvent is a cross-browser wrapper around the browser's native event. It's API is same as the browser's native event, including stopPropagation() and preventDefault(), except the events work identically across all browsers.

[**⬆ Back to Top**](#table-of-contents)

### **What are inline conditional expressions?**

You can use either _if statements_ or _ternary expressions_ which are available from JS to conditionally render expressions. Apart from these approaches, you can also embed any expressions in JSX by wrapping them in curly braces and then followed by JS logical operator &&.
```jsx
<h1>Hello!</h1>;

{

messages.length > 0 && !isLogin ? (

<h2>You have {messages.length} unread messages.</h2>

) : (

<h2>You don't have unread messages.</h2>

);

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is "key" prop and what is the benefit of using it in arrays of elements?**

A key is a special string attribute you **should** include when creating arrays of elements. _Key_ prop helps React identify which items have changed, are added, or are removed.

Most often we use ID from our data as _key_:
```jsx
const todoItems = todos.map((todo) => <li key={todo.id}>{todo.text}</li>);
```
When you don't have stable IDs for rendered items, you may use the item _index_ as a _key_ as a last resort:
```jsx
const todoItems = todos.map((todo, index) => <li key={index}>{todo.text}</li>);
```
**Note:**

1. Using _indexes_ for _keys_ is **not recommended** if the order of items may change. This can negatively impact performance and may cause issues with component state.
2. If you extract list item as separate component then apply _keys_ on list component instead of li tag.
3. There will be a warning message in the console if the key prop is not present on list items.

[**⬆ Back to Top**](#table-of-contents)

### **What is the use of refs?**

The _ref_ is used to return a reference to the element. They _should be avoided_ in most cases, however, they can be useful when you need a direct access to the DOM element or an instance of a component.

[**⬆ Back to Top**](#table-of-contents)

### **How to create refs?**

There are two approaches

1. This is a recently added approach. _Refs_ are created using React.createRef() method and attached to React elements via the ref attribute. In order to use _refs_ throughout the component, just assign the _ref_ to the instance property within constructor.
```jsx
class MyComponent extends React.Component {

constructor(props) {

super(props);

this.myRef = React.createRef();

}

render() {

return <div ref={this.myRef} />;

}

}
```
1. You can also use ref callbacks approach regardless of React version. For example, the search bar component's input element accessed as follows,
```jsx
class SearchBar extends Component {

constructor(props) {

super(props);

this.txtSearch = null;

this.state = { term: '' };

this.setInputSearchRef = (e) => {

this.txtSearch = e;

};

}

onInputChange(event) {

this.setState({ term: this.txtSearch.value });

}

render() {

return (

<input

value={this.state.term}

onChange={this.onInputChange.bind(this)}

ref={this.setInputSearchRef}

/>

);

}

}
```
You can also use _refs_ in function components using **closures**. **Note**: You can also use inline ref callbacks even though it is not a recommended approach

[**⬆ Back to Top**](#table-of-contents)

### **What are forward refs?**

_Ref forwarding_ is a feature that lets some components take a _ref_ they receive, and pass it further down to a child.
```jsx
const ButtonElement = React.forwardRef((props, ref) => (

<button ref={ref} className="CustomButton">

{props.children}

</button>

));
```
// Create ref to the DOM button:
```jsx
const ref = React.createRef();

<ButtonElement ref={ref}>{'Forward Ref'}</ButtonElement>;
```
[**⬆ Back to Top**](#table-of-contents)

### **Which is preferred option with in callback refs and findDOMNode()?**

It is preferred to use _callback refs_ over findDOMNode() API. Because findDOMNode() prevents certain improvements in React in the future.

The **legacy** approach of using findDOMNode:
```jsx
class MyComponent extends Component {

componentDidMount() {

findDOMNode(this).scrollIntoView();

}

render() {

return <div />;

}

}
```
The recommended approach is:
```jsx
class MyComponent extends Component {

constructor(props) {

super(props);

this.node = createRef();

}

componentDidMount() {

this.node.current.scrollIntoView();

}

render() {

return <div ref={this.node} />;

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **Why are String Refs legacy?**

If you worked with React before, you might be familiar with an older API where the ref attribute is a string, like ref={'textInput'}, and the DOM node is accessed as this.refs.textInput. We advise against it because _string refs have below issues_, and are considered legacy. String refs were **removed in React v16**.

1. They _force React to keep track of currently executing component_. This is problematic because it makes react module stateful, and thus causes weird errors when react module is duplicated in the bundle.
2. They are _not composable_ — if a library puts a ref on the passed child, the user can't put another ref on it. Callback refs are perfectly composable.
3. They _don't work with static analysis_ like Flow. Flow can't guess the magic that framework does to make the string ref appear on this.refs, as well as its type (which could be different). Callback refs are friendlier to static analysis.
4. It doesn't work as most people would expect with the "render callback" pattern (e.g. )
```jsx
class MyComponent extends Component {

renderRow = (index) => {

// This won't work. Ref will get attached to DataTable rather than MyComponent:

return <input ref={'input-' + index} />;

// This would work though! Callback refs are awesome.

return <input ref={(input) => (this\['input-' + index\] = input)} />;

};

render() {

return <DataTable data={this.props.data} renderRow={this.renderRow} />;

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is Virtual DOM?**

The _Virtual DOM_ (VDOM) is an in-memory representation of _Real DOM_. The representation of a UI is kept in memory and synced with the "real" DOM. It's a step that happens between the render function being called and the displaying of elements on the screen. This entire process is called _reconciliation_.

[**⬆ Back to Top**](#table-of-contents)

### **How Virtual DOM works?**

    The _Virtual DOM_ works in three simple steps.

    1. Whenever any underlying data changes, the entire UI is re-rendered in Virtual DOM representation.

       ![vdom](images/vdom1.png)

    2. Then the difference between the previous DOM representation and the new one is calculated.

       ![vdom2](images/vdom2.png)

    3. Once the calculations are done, the real DOM will be updated with only the things that have actually changed.

       ![vdom3](images/vdom3.png)

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between Shadow DOM and Virtual DOM?**

The _Shadow DOM_ is a browser technology designed primarily for scoping variables and CSS in _web components_. The _Virtual DOM_ is a concept implemented by libraries in JavaScript on top of browser APIs.

[**⬆ Back to Top**](#table-of-contents)

### **What is React Fiber?**

Fiber is the new _reconciliation_ engine or reimplementation of core algorithm in React v16. The goal of React Fiber is to increase its suitability for areas like animation, layout, gestures, ability to pause, abort, or reuse work and assign priority to different types of updates; and new concurrency primitives.

[**⬆ Back to Top**](#table-of-contents)

### **What is the main goal of React Fiber?**

The goal of _React Fiber_ is to increase its suitability for areas like animation, layout, and gestures. Its headline feature is **incremental rendering**: the ability to split rendering work into chunks and spread it out over multiple frames.

[**⬆ Back to Top**](#table-of-contents)

### **What are controlled components?**

A component that controls the input elements within the forms on subsequent user input is called **Controlled Component**, i.e, every state mutation will have an associated handler function.

For example, to write all the names in uppercase letters, we use handleChange as below,
```jsx
handleChange(event) {

this.setState({value: event.target.value.toUpperCase()})

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What are uncontrolled components?**

The **Uncontrolled Components** are the ones that store their own state internally, and you query the DOM using a ref to find its current value when you need it. This is a bit more like traditional HTML.

In the below UserProfile component, the name input is accessed using ref.
```jsx
class UserProfile extends React.Component {

constructor(props) {

super(props);

this.handleSubmit = this.handleSubmit.bind(this);

this.input = React.createRef();

}

handleSubmit(event) {

alert('A name was submitted: ' + this.input.current.value);

event.preventDefault();

}

render() {

return (

<form onSubmit={this.handleSubmit}>

<label>

{'Name:'}

<input type="text" ref={this.input} />

</label>

<input type="submit" value="Submit" />

</form>

);

}

}
```
In most cases, it's recommend to use controlled components to implement forms.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between createElement and cloneElement?**

JSX elements will be transpiled to React.createElement() functions to create React elements which are going to be used for the object representation of UI. Whereas cloneElement is used to clone an element and pass it new props.

[**⬆ Back to Top**](#table-of-contents)

### **What is Lifting State Up in React?**

When several components need to share the same changing data then it is recommended to _lift the shared state up_ to their closest common ancestor. That means if two child components share the same data from its parent, then move the state to parent instead of maintaining local state in both of the child components.

[**⬆ Back to Top**](#table-of-contents)

### **What are the different phases of component lifecycle?**

The component lifecycle has three distinct lifecycle phases:

1. **Mounting:** The component is ready to mount in the browser DOM. This phase covers initialization from constructor(), getDerivedStateFromProps(), render(), and componentDidMount() lifecycle methods.
2. **Updating:** In this phase, the component get updated in two ways, sending the new props and updating the state either from setState() or forceUpdate(). This phase covers getDerivedStateFromProps(), shouldComponentUpdate(), render(), getSnapshotBeforeUpdate() and componentDidUpdate() lifecycle methods.
3. **Unmounting:** In this last phase, the component is not needed and get unmounted from the browser DOM. This phase includes componentWillUnmount() lifecycle method.

It's worth mentioning that React internally has a concept of phases when applying changes to the DOM. They are separated as follows

1. **Render** The component will render without any side-effects. This applies for Pure components and in this phase, React can pause, abort, or restart the render.
2. **Pre-commit** Before the component actually applies the changes to the DOM, there is a moment that allows React to read from the DOM through the getSnapshotBeforeUpdate().
3. **Commit** React works with the DOM and executes the final lifecycles respectively componentDidMount() for mounting, componentDidUpdate() for updating, and componentWillUnmount() for unmounting.

React 16.3+ Phases (or an [interactive version](http://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/))

![Alt Text](data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAQEBAQEBAQFBQQGBgYGBgkIBwcICQ0KCgoKCg0UDQ8NDQ8NFBIWEhESFhIgGRcXGSAlHx4fJS0pKS05NjlLS2QBBAQEBAQEBAUFBAYGBgYGCQgHBwgJDQoKCgoKDRQNDw0NDw0UEhYSERIWEiAZFxcZICUfHh8lLSkpLTk2OUtLZP/CABEIAeIDcAMBIgACEQEDEQH/xAA1AAEAAgIDAQEAAAAAAAAAAAAABQYDBAEHCAIJAQEBAAMBAQAAAAAAAAAAAAAAAQIDBAUG/9oADAMBAAIQAxAAAAD38AAAAAAAAAAAAgdYs6sizKyLMrIsysizKyLMrIsysizKyLMrIsys4C2lLLorIsysizKyLMrIsysizKyLMrIsysizKyLMrIsysizKyLMrIsysizKyLMrIsysizKyLMrIsyv7BMKyLMrIsysizKyLMrIsysizKyLMrIsysizKyLMp1xAAAAAAAAAAAAITPgzgADrHs7x0d43vxDvnteB8oSx6QsnjzKeupjw/7gAAGlu6RYK1Za0SQAAAAAAOq7b5Mhj2nGeQ4I9my/lLcPWu74M9LHcgAAAAAAANbb1Ns+QAKdcfOh2ZZ/Hv0evcnjeOPb+v44zno23+R8x67kPAnskuwAI2zVmzAAAAAAAAAAAAEJnwZwAAAABgzilXUAAGlu6RYK1Za0SQAAAAAAEVKgACl2raAAAAAAAAGtt6m2fIAAAAAAKLd/sAARtmrNmAAAAAAAAAAAAITPgzgAAAGlux8gAAAANLd0iwVqy1okivFhV2wnIDgcuByAA4HKJpp2QjeSRcVYtQABXywOBy4hiaQsufaL+yRaGkSe3qbZ8gAAAAwZ4yTAAAAI2zVmzAAAAAAAAAAAAEJnwZwAAACNktDfAAAAGlu6RYK1Za0SXWXZo8Y5fZI8sWb0DFHmGM9jRR5P7C9BgADorqD2oPJMl6kHh6T9nDxt3v2FwSIAHmf0wPJG/6oHjW9+jx4xxevpU8U7/sceV+271kM23qbZ8gAAAA0d6MkwAAACNs1ZswAAAAAAAAAAABCZ8GcAAAAjZLrbsUyAAAAaW7pFgrVlrRJAAEKTQAAAAAPn6jZIAAAAAYM8YSYAANbb1Ns+QAAAAaG/GyQAAABG2as2YAAAAAAAAAAAAhM2HLVYyfG16/nYGcYGfrqW/Os4/G9uOi7DHabraAruh1F2rlNhnWYGcbebU2/L7rBWrLWteckABDzEYSYAAAAANDfjJMAAAAAaO9GEmAADW29TbPkAAAAEfIR8gAAAARtmrNmAAAAAAAAAAAAITLizlX2sf16vn/T5H11n2Ul6i++2mOXQ9n7LzHSu924Ol+6vlcfp8sp9PkbG38/XndtgrVlrWvOSAA0N+NJIAAAAAGjvRkmAAAAANDfjSSAABrbeptnyAAAACOkdDfAAAAI2zVmzAAAAAAAAAAAAEJnwZwAAADR3oyTAAAAGlu6RYK1Za0SQAEfIVosoAAAAANHejJMAAAAAR8hHEiAADW29TbPkAAAAEbJaG+AAAARtmrNmAAAD5xGcBxyGHKcgOByAACEz4Mpp44jb9Dk3GmTcaY3GmKbc+BuNLk3GmNxp/JvNMbmnxyTEJ9jcaY3GmNym2YbjTG40xuSEHsadksOXoAAj5CNkgAAAABGyWgb4AANbb1Ns+QAAAARkno7wAAABG2as2YAAccjpLyx+imkeDrn62zngTsj1Vtnl2ie4B4LtvrfIeP/AFlK7wAABCZMeWqztam37PmgAAee6/3dY9GzzbP96/ddDa/ofAef4r0r8HmOc78+48+WHu/FlOh4f0f9S9HRvomErpnteXkbjmGzEABsa+zzbpUed2AAR8hHSIAAAAAjJPQN8AAGtt6m2fIAAAAIyT0N8AAAAjbNWbMAHSvZRYFJsJKqbpF/dcypcVVzljVGVJl1/GHaaM62O3HVUyXx112KAQmfBnIz5lWzCKSqopKiKSogNr7kiKSoikqIpKiKSoitSwaUfcPda0Y0sqJSwicE7FnCVEUlRFSORhQxyAAjpHQ3wAAAABFymibwAANbb1Ns+QAAAARknob4AAABG2as2YA60gu2/KhfrTozhSse5vFhpE9Flc7jq0ERd+pHf50NGfFyNmM+6wY7jH3E609A0LsYAhM+DOAAAAaG/GSYAAAA0t3SLBWrLWiSaGrswmUMsmYXmiHaiGEyhhMoYTKGEyhhMoYZJXqLsQmUMJlDCZRknhmGNARknoG+AADW29TbPkAAAAEdIx0iAAAARtmrNmAMfVXbI6qz9ndcmrv9NcnYbrTZOyvmk/Je7l09PnxM9Kzh3FAUawlpmLpyV2xABCZ8GcAAAA0d6LlAAAABpbukWCtWWtGlzxz6vAG3Bp9ZU3Xn6L1PNE/je74/zv2FHdTz3Va9XPN2Oz0rg82l9ATPn6Fj0hk8v/J6pdJ92bMQyxwWWtWXg6Q5OkBGyUeSAAANbb1Ns+QAAAAR8hGyQAAABG2as2YAAfH2ITFYBW5SQFek94Ue55RhgbIK3tzI45AACEz4M4AAABob8ZJgAAADS3dIsFastaNHie1uvnikqzxikqIpKiKSoisE4IpjkE00gmUfrzqyKSoikqIpKiFs2LLz7g07AEdIxxIgAA1tvU2z5AAAABob8XKAAAAEbZqzZgAAAAAAAAAAACEz4M4AAABob/WnY5kAAAA0t3SLBWrLWiSAAAAABG1WM7PPO3bduc3sh0+KCgAAAAI/boR2EAADW29TbPkAAAAGjvRcoAAAARtmrNmAAAAAAAAAAAAITPgyEFzrbXq8HDlXDkcORhy8jhyOHI4cjhyOMOcZdLYHDkcORw5gZZ1T+Yt7rW2E85ZTDl5HDkcORw5HDkcORw5HDkcORxqbg4cjhyPmdgZXk3/e3qbfJ0fIAAAANHejJMAAAAjbNWbMAAAAAAAAAAAAQmTHmsrG1p5PX87Ya6thrjYa42GjmNhrjYa42GuNhrjYa/ybTBjNtrjYa42Ope0mN8sWb0Cwz8ndw9oE2Gu24bDXGw1xsNcbDXGw1xsNcbDXGw1xsNcbDXGw1xsNcZZWDsXH0fG3qbfF1fIAAAANDfjZIAAAAjbNWbMAOGqbTXGw1+TO1vszc6eUzNTKZmr9mdrcmw1/k2ucOYAhM+DOAAAAaO9GSYAAAA0d7SLBWrLWiSAAAAAAAABob8ZJgAAAAAAAAGtt6m2fIAAAAI+QjpEAAAAjbNWbMAAQFNunm09XPFk+dzdneR6ye3niKLPcmDxJ3mWm9+Yq8e1fr89B7ksnRnewABCZ8GcAAAA0N+NkgAAABpbukWCtWWtEk0uPO3bzRarvNEbzRG80RvNEbzRG80RvNEUHsvQ+jeaI3miN5ojeaI3miN5ojeaI3miN5H7vXhh29Tb69fyAAAACNktDfAAAAI2zVmzAAAAAAAAAAAAEJnjJcxsoxMoxMoxMoipCPkThlGJlGJlGJlGLSkq8W+tWSqG7mwZ/l+8NOYAAFTx9XTXXqxXCn7pa8XVFjsnZ6n5VjbhStGy4TtcjpbbirWlJZ5rrffqx9j+fe/8AVnkGjMAADhx9+nz49uKz+3y7jKMTKMTKMTKMTKIiSjJgxMoxMoxMoxMoiLNS7oAAOre0qeUn62pIlKJ2pQCMmsFvOmLjL7BFVDs6OOprfbcR2W+foAArljrljAAAANbY1do5AAAArtirpYYyTjD507Fx5m+vLC1ZV5YRXlhFeWEV5YRXlhFeWEV5YRW/v5sZXlhFeWEV5YRXlhFeWEV5YRXlhFeWEV2xOevVA5sObt1zAAAAAIuU0N8AAAArNmrNmAD5jiTRwkUeJBGfZIIvKb6Lym+jPskEcJFH/JJNDfAK5Y65YwAAADS3NCQAAAAFdsVdLDGScYSgAAAAAAAAK3ZKlbQAAAAAAAACBzYcxMAAAAAipXQ3wAAACs2as2YAAAAAAAAAAAArljrlgjQ+dLP892ZmEuZhGZhR1/ffsZmFWZhGZhGZhGaIkUZI3N9WbjAXOwDO1vpM7ByZkd81JtVLtMHBsNflM7UyrQew8SMzCrMwjMwjMwjMwjMwjMwjMwjYkYOd79MDmw5vT0TAAAAAIuUjZIAAAArNmrNmAABwcqKL04HLiqlrVurnZjgclNLkAACuWCv2HFAZ8Gf5L0goAAAAAAADpvpz2N8dWvy3i9UrOtenvVkZi81RPr1nPL3YPcDHLyht+pfmzyTd/QXzHmmA9bcV1h0v66+Mb569E48muhqzAAAAAAAA+ZuDnfT54HNhze3yzAAAAAI2SjpEAAAArNmrNmAAAOgKh6uHhSS9sjwHue8B5/p/rAeEK3+iY8Ne0ZQAAAVyx1yxmlxvOTZot5Gi3hot4V3f4kzRb40G+NBvjQb40Iez103tCxRhmbw0W8NFvDRbw0W8NFvDRbw0W8NFvCqzUXZDRbw0W8NFvDRbw0W8NFvDRbw0W8NDe5bsYHNhzbsZgAAAAEfIRskAAAAVmzVmzAAA6LO9HSliOyXTP0dyPOnbBc3QOoeiXUtaO/3RVFPV6EmwACuWOuWMMWOTZYRmYRmYRoyfWk+W1hGZhGZhGZh+oyV2w17K2GMk4wlHGOTKwjMwjMwjMwjMwjMwjMwjMwiBsnS3bpuMIzMIzMIzMIzMIzMIzMIzMIzMeRYHNhzVMHByx/MmZhGZhGZhGtv9OdsG2wjMwjMwjMwZSt2asWe0AB1f2gOortCUEt+xC1A7PkOg7QXrf62o56I0OmZw7ExRHdBWLOAAFcsNesGLrzNiz8Xn/Lz9G55+k3nqJPTbzXzXpN5tqh69eTZc9NvCPbK+lXSFJk9S8Vq0Y4WyO3NHr7rJGScZnlDxcnHcXD8vpMfl9D5fQ+X0Pl9dQ29uPPkdb6Uead1fRLznDV6leZqyev3m2NPUjydwesnnKqnrdrbeGHy+h8vofL6Hy+hjv9Eu+zdEZsObq6piIl4XDCsc9bdfcvJ6Kecucr6MeZJY9CvLuA9UvHkmvrB4w7ET0W89xaemHm2cjvbe8veoZltWir2jt7AABSC5VfzjunqKA83aB6dlfOsod7bnn3rQ9XZvM+iembl447sO3AAAVywV+xR13nnPnk4+t9XtJbRaj3QXq3e7EJ17q9mDrH67MHW3x2YXrTa7BJVt+aSb2jY691ddhjJOMysPG22M5eWFTTHGFTQhU0IVNCFq/YRet9q/K6Qs/ZBaFFdpE690e0B1pg7SHS012eXrPT7YEH9TSYwqaEKmhCpoQqaELd4KybdsDmw5t++YhpnFjj1LGdnObmolQ7qHWMlfB1hu9hCi478OvtDtAUTHfx1bs9kjry6b+9bHWesWfq6gAAOHI4chxyGDOOOQ45AAACpSkzwQ6YEOmBDpgQ6YEOmBDpgQ6YEOmBDpgQ9fvAUO+CurGK4sYrixiuLGK4sYrixiuLGK4sYrixiuLGK4sYrixiuLGK4sYrixiuLGK4sYrixiuLGKnmsorqxiuLGK4sYrixiuLGK4sYrixiuLGK4sYrixigX8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP/8QAPxAAAAUBBQQJAwQCAQMEAwAAAgMEBQYBAAcUFVQREhMwFiAxMjM1QFJVNFFTECE2VhckIiNBUAglRHAmQkP/2gAIAQEAAQkA/wDoZ8CIwTYVQ+jWClNlHDLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I0SVSOLRUtaLbwhWbENT25AcY45YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/I5YH5HLA/IswBkrnInESAJvBR0oflgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8jlgfkcsD8ioSiRGt55S71Lv47L1x3rMBd5pd3g0cGvei89NllEIE0jjy1CJwTPx7u0pRKQnujxPImysr08nPaGfMrg5J0xNEb2yuJqglE7opCwORtCkL51j/MGGwvDFZm8naeeVe2wHRSbSWiBLMo2e3Ny054fpQyRtGeocHBmn0ZdmCPvRrm43kxlA9PbEE9NMGAbYgXrXNW+MqDCYt4Sqkq0gtQlU+gbfNHW0i7jZ1qTZtrPhQnDRa8iNyhA5LQngkLAYkIWAe08ljisxGWnfxSBhA50ahPYnhoAUeaJ1OkcfTqAJjn1fetGEo5knS2Nk0eTVABU+LXxkbjyk614KOKUFFHEm9Rz7rf6p38dl695kVm4bwZnLGCPf4omDWzzBATGnqFSF+Q3rOkZgMwZphNf8zOSaCyu6tSW7XlJWOFucPkK9K5jbYY7XZuzYpTZAxXaktpV611YEME6x/mDDYXhiszeTtPPcUE0Y41e7AwXfSFgSpZjPmddAFcCkbUYsIlEAe4RM1TIzNx0DHCnkhyWH1hDfdmvc3TfeocCOrmboyOUwX/0/UrS5yCbfQtvmjraRdxs60yq+w6+VFNS4izXayNagu5zuJF3Zu4lKVsHDyrqVrcQarQQldBpEIl4j/wDj6TMc2LQXkRcmCS67Bzcme/dfSGzODPGLv+IQQeT3Yr3k6/tcfDpuzGtx945r/DbtaVDd3BKVp1HPut/qnfx2XmqkqZcmUJVREau5g8PVnrGGM9Y/zBhsLwxWZvJ2n0CdjaUrs4O5CDqSa7uEzI9Mof42iRI21GmRok3oG3zR1tIu42c9/uygMpcwOj1FSyyySyyywdRz7rf6p38dl9Kf5gw2F4YrM3k7T/4dt80dbSLuNnpXPut/qnfx2XlOBphKcIizOUf5gw2F4YrM3k7T/wCHbfNHW0i7jZyyThmmKgCI5Ln3W/1Tv47LynPbhgbKco/zBhsLwxWZvJ2n9JVKGeGMC99eDxSploOMgAp20rt/f9NtNm3btptrTbtpt2baVpXbsr1K1pSla1rtpSm3arfGlAuJQKVyC9KOuDi0JAo2t4bXpHjUCo52biHRE1mKd4NKCrUTVMmV5VIE6UfVdJI3tTqyNRgKVDXbsrUQaf8A7babaU2oH9ucnV9a042F/bZI1lOjcYYYAoAxjGyvCJ+aGt1RCTuzcrcXFtJUuTmgaG9W4rVLTIETuoXJSi23zR1tIu42ctBw8W9bnKc+63+qd/HZeU61DRKXvV5R/mDDYXhiszeTtP6XiIzXpbAGSiVYhmzAbJmdAhDHBij86c2QTAyyx6nTgkdk147lF1F4scbZKFhh7krLLJXsdFLSiaWOSMBCFuZECJhWRtPcs3EJnGQmJkPUvmOSHmxtCqWqSFtclb3pjKYyGNe6mvceaVIkispLGn4xO2oYwzM5MeVti1GjVL0KYtoMTNMqWMqk8gtTebF0SArq3ktx50plr+mbXJib157yVCW1xj8PJf5awO8ao0usikK1KrVNkvKjdb0EJiApti6JU/sD43OyGg2GWs8oRysgpyWqkRLa9o6hXSdeUmjTIeWqiCAQIpUTnPLxHkqzb5o62kXcbOWl4mJct7lOfdb/AFTv47LynKg6py9zln+YMNheGKzN5O09ZOyt6V3c3coqz0yt8hbjm5xK5js1IXtuVN68lvaULYJeNMTymtlb2ermJGT+rk0IXUSAaktrbELKgTN6BO2+aOtpF3GzlouHjXjd5Tn3W/1Tv47Lynbh4Ynf5Z/mDDYXhiszeTtPoxDACoKCHzExwzyQmDI6zb5o62kXcbOWl38W50FXkufdb/VO/jsvKvKkUojaBmPY2Ani0JK41eSf5gw2F4YrM3k7T1gmhrIjSeJzF+7xmrerzGfh4Avh9dt80dbSLuNnLSbtF7rspyXPut/qnfx2W1a7KVrYkR6sotQYq4AtXwBavgC1fAFq+ALV8AWr4AtXwBavgC1fAFq+ALV8AWr4AtXwBavgC1fAFq+ALVth5pgVBZoz/MGGwvDFZm8naesXRRn6utQcxZv1Obd2nMbeJhA8TrtvmjraRdxs5abbj3Km3kufdb/VO/jsth9wdkP0SPqyS8xmjTwNpG2f5bjmeVbMC233xNwqUYNA4X5phR0t4aIx/mGPUUOxVWlyvXYG9WtQAb631IAP1CT2Ud9sbSI15zgzta6rm3o1tUXUavFcrH+YMNheGKzN5O09YNC85Prs5jhw+Oz7/NZ6F0QA3Ou2+aOtpF3Gzlp/MHL9uS591v8AVO/jsth9wdkP0SPqyG7fOpCoekUqrdCgznE9IE90DSlQxZIU9IrhWhGheSaSBVdU3KmCSNNXkNzBRJtV5MyW3PtjlwKLZFS5hKrqee7ynqtXiuVj/MGGwvDFZm8naesGo80PpWvMWcTitu5zWyo6pKb9es2+aOtpF3Gzlp9mZOOyvJc+63+qd/HZbVptsBC4JghJLL4DppOA6aTgOmk4DppOA6aTgOmk4DppD6rUpVTTiOA6aTgOmk4DppOA6aTgOmk4DppOA6aTgOmk4DnpECUaYBtTBH+YMNheGKzN5O09Yugc3V12cxw4eIZt/mtNA0RU3adZt80dbSLuNnLJ3sxXbeU591v9U7+Oy8py4mEFw+Wf5gw2F4YrM3k7T1i9uaq/35izicZs3Oa17cH+9es2+aOtpF3GzlkbmbONKV5Ln3W/1Tv47Lynjh4EXE5Z/mDDYXhiszeTtPWSvjKc/rEhTrzHDh4lm3+a1/R9nWbfNHW0i7jZyyqGZitrWnJc+63+qd/HZf0Nc0BIxFjU5u3ajN27UZu3ajN27UZu3ajN27UZu3ai8ZM6yBhAVGZOgWtyFCkS4/N27UZu3ajN27UZu3ajN27UZu3ajN27UZu3ajN27UKXRDVW0jCeJ9bNwWxU1OaIprbSzDs3btRm7dqM3btRm7dqM3btQijcNQTV4mBFM3btRm7dqM3btRm7dqM3btSAYRhCIIust3+O1bteY1VpVHXZXrNvmjraRdxs5ZHCzhx2cpz7rfyDFJIN6lTSFyRSLdKV/oA4sYhhCZY9amTVCE9SBQSMQA0N/QZgCwCGMZZ5Ru9uGdZ38dlsOuwIq2QUpREkryttK12bepvBrWod79K1pTtr+m2lLUrSvLZ/2IUBp1127iWfbTmNm9ha71Os2+aOtpF3Gzll8TMlm3lOfdb+vWm2laWmN2qJoYJi+AfIw2ukRW3NvRUWQXxXm0i0mc+lEkn94cSUzFkUzIqcySPOUwLZ5fDZpeXLX+75pOlt9bIc+XtXboSYumhs0hz3D2akrkN+M6ydlckUlUXszFFeYqSnP12MumF56/IpG+RmEtETE61b69Z38dlsPuDsh+iR8hVeFIUytMsA7nTCXO7QGhz+4gjhbHPF5Sou8GXGvq39wySVN2Cd1S1yvFlw8MYnPWSp7fjW0xa+MtEaJwjqso4F4j+zRFgEnkJ0rkrW5ubene0qZ3nT63LFbEqfpI3qnFMS89LZkuMVoUcifXWSujfRqc1BLJK4qqSlojV14UmSNQ3Up7VTSUphmokkngz0a/xlEuOUddo8JX11u3ENP78xp3KoxbnXbfNHW0i7jZyyeHnLhs5Tn3W/kGlFnlGFGAyZD/p/6JUZZCwrAFMxrG3KsTQ5AGMsdUpyPJU7MgIGQMlCNuTGKCVQ05rYlNNocamHFmE6pdRsYY8zAW0cAtKJja0KlQpStvXd/HZbD/cIrIP3Qo+QRBGwmRBfDFpbKzEkqSCmktoaSlVVZbXlbZRWaty7BpNmzCqWprWATFqW0xqazVYVhjaUzNBC01eU1DYWIypdRsp7KzKSzSj2gCdOUKgiyDkCFSSpJORFN6AgooolDVCirWlaoxlFGVLEMtzjDK6I3tOYhLYGQtGcio0J05CQgohOR12jwVVeut+paea3UMomFxKdZt80dbSLuNnLL4mZrNvKc+63+qd/HZf0G0pRCEIIsoI1GUEajKCNRlBGoygjUZQRqMoI1CxvAnIqYAzKCNRlBGoygjUZQRqMoI1GUEajKCNRlBGoygjUZQRqD20sClrLCpEwpd0VaHtrcBQ3N5xinKCNRlBGoygjUZQRqMoI1AW0sSk4mtcoI1GUEajKCNRlBGoydP8A91BJJScsBRQOstrTFNG2vMZ+Hgh8OvWbfNHW0i7jZyyqAzhfWnKc+639R+vOfWpZOBp44hmsdUIyz6Lw3swExHjCn06WMBbBR/zMV6cGAhotG9O97cJbmYlxC8u94CZjjUVf1ZAr0YQFvSL83MvKhRaluT1e5BN4zFDEZbw4Kbz4OkMRAMfX6XsUbLTDc1Zl40cTiWqD3ZrvcialtzJavXytib2Wj0ocX295gQijVW0UdvgjCmPsLm9LHS8yHNq1ahMd2W9iHL0jAca4fq7+Oy8p23KIq7/LP8wYbC7grM3k7T1ieFnLjs5qug8U1bvNbuLhxcTrtvmjraRdxs5Ze9miym3kufdb+ogutYjJRL3t9ZFl3ksz1Vh1am6R8KaoKFKcbA3oi7VLGWpZGbrJE0PhLisODddMWkTwa1KlcNXqGCCt3Hd7r5acuVHJHFHdDNECeNFEqnOMLF0rYXoJie6SYN0fdGBMsnsKdpCUxVQJkt1czb1TU8UeDLnpdRQW6iUvl2ypfAmCOoj2W692QqG1cdVVcm/UTpiSlCGAytrNXtidSVdPNCAxzhqWot1oWdVz/V38dl5Tlv1S/wDDln+YMNheGKzN5O09YhxSGOyooK7mLzCAq2nfHzGjh4MfDp1m3zR1tIu42csvzZb+3Jc+639R+VGo2Z1PIEqvfm1LoEpwFy29gCKVEx8bbGLwkkpVs6ZGha7zX1Csds4Z4ZfE1zF4RtydO4XnKUDo8k1jRt9KRO6uSA9rf700zEUcOrWrvtRpEjR/oPt8Divjjo4RZlGfUJFK7XW+5UsancDWgreg4lrhMR0TBes4rj0zc3RMi/sSFiYzXZvdbzXlWobskaJJNFzU7VaWpgid4Ipg7KU7ay/q7+Oy8p34eC/515R/mDDYXhiszeUNNla8CUYS6E5qb8bmp3xuam/G5qd8a3xJmbZ29zMlpzU343NTvjc1O+NzU743NTvjc1N+NzU743NTvjc1O+NzU743NTfjc1O+NlcPRyuSxN8PT5qd8bmp3xuam/G5qd8bmp3xqdyCaaAoxP1m7fww9/rtvmjraRdxs5ZfmyvlOfdb+o5JALEKlIOxlzcVHRXtoO6lrq61cC3e7yHHRoUqcliUF17RR0OWGOcagKGLq05qd3JuzGtkMnXubuTc4wFDS0q7prqECbEGUk5d0rMlAUake3G6VkXBUklu6FmVATvidwX0uTYRpCUp7/W69uGISwb+ywBmYlJCok8q6JoTJ0idI/mXXtY3QKsLpKIGkkDiFeU7RiKtcWE45cX+rv47LynHiVTU4dOUf5gw2F4YrM3k7VZR5op6pC9GqULU5J9lS9GhEkCpULnppbBmhWr2SXR6RHHkNrj1VCpMkLCaoUDkDKWgcHAbjbHJMdgOOYqTFHkJzFHUN8RH12ncokM3Ou2+aOtpF3Gzlg3s1UftyXPut/Xm7rIk79DWpnXNd588VpynMQaSiXOa+NIFr+O9iXEkua4Cp7kc4iLy/L1L+hm86UOiWNqHAlSpHcPODzXFRNZbGlyopW9rnl1fbmpe9ra0KWQZ1iLuRCkt5U2TIFYl6lmn0yd15ccG6wV5dlM0eVTpLqVpXrO/jsvKeOFVGChnLP8AMGGwvDFZn8narKPNFPUvVRrlZDHwApIu+GhXPhrYc0ys9qVFNyB3rKJI8qlzY0VjLi4BJMQR2SurtJ0ywbPE0EbVO72jTloVbO/sEcZzzggQKaOFTFDN0Xlitndla8sDXNxyJ1MNs5wtenb0ReXuid0AxzaIgj4CXxeudDY+TVtXk0VntUcQskpHhTiWy6tA9JV7gNTT9TfER9ds3qph73XbfNHW0i7jZyw7mcHfvyXPut/XObkilQnUHJyITE0ypxWEx1JAochSYNNGAXdQUoZxgIkri7AvOqesaAwCG0aMnrGCo0xENg2stpebuWE+OOTE1J6NiE9tC3GJDWRsUCRCORFwCFJETiiIi3+O4NVGairEjYhFzKl1MYKUpTrO/jsvKceJhwcOvKP8wYbC8MVmbydpssrQpzHUdeIX7+IX7+IX7+IX7+IX+TiF+/iF+/iF/k4hfv4hfvUkolhdClJfEL9/EL9/EL9/EL9/EL96YlEjAYBOXxC/ycQv8nEL9/EL9/EL9/EL99RBOUoiixdZq2YUzZ123zR1tIu42cunEzQf7clz7rf6p38dl5TtuVSlUHyz/MGGwvDFZm8nabGFlmhqAwvL0Ghy9BocvQaHL0Ghy9BocvQaHL0Ghy9BocvQaHL0Ghy9BoTzUCVxVFHoEwGVYJUFOSFM0jMNKCnJStKguhhKfL0Ghy9BocvQaHL0Ghy9BocvQaHL0Ghy9BoSiCCKVoUT1mv6UzrtvmjraRdxs5dOHnQuU591v9U7+Oy8py38OVucs/zBhsLwxWZvJ2nm0CMxevBUUOu+bIStkCpA63gsshd5UvrEUEFo3BizRRvaue2baJjNtOs2+aOtpF3Gzl14mZB5Tn3W/wBU7+Oy8q8ybFwhAzKFDASIwZJQjC+SorsXsVbC7grM3k7TzWac5nePJIvSOehPMEUSaYAm7ubM82b3JQ0kdZt80dbSLuNnLFws5K5Tn3W/1Tv47Latdlgr16gITShYl11GJddTiXXU4l11OJdNTiXXU4l11JwlygIQnDxLrqcS6anEuupxLrqcS66nEuupxLpqcS66nEuupxLrqTBORhqU2qoS93EGocQlq5JEyZOBViXXU4l11OJddTiXXU4l11OJddTiXTU4l11OJddTiXXU4l11OJdNSES0Bxp4RYl11OJddTiXXU4l01OJddTiXXU4l11OJddTiXTU4l11OJddTiXTU4l11OJddTiXXU4l11OJdNTiXXUIiT24owpHTEuupxLrqcS6anEuupqtcyqVGIRRgTSyzAVbfNHW0i7jZyxVMzImnKc+63+qd/HZbD7g7Ifokfq18pjjW4p2xc9p7woMrRrVhEtpeDB6tFXjpW13sQtczkOyx4JlUbUO9Gcl89UZ4Y7N3l6Czb5o62kXcbOWZw84Sbaclz7rf6p38dlsPuDsh+iR+rkt3B0klUgdDTkNxUlq1nJ1lXC6mTFSJa/Nlh3DS8pK3DCpu/u7Nh71JFx/qzPDHZu8vQWbfNHW0i7jZyx1HmiWnKc+63+qd/HZbCptpWlieKjKKIOTYmmmxNNNiaabE002JppsTTTYmmmPcE6YuppxeJppsTTTYmmmxNNNiaabE002JppsTTTYmmmxNNMJYWARYREVP2f/ABS1pRxYDCycTTTYmmmxNNNiaabE002JppsTTTYmmmxNNNiaabE002JppsTTTYmmmxNNNiaabE002JppsTTTYmmmxNNNiaabE002JppsTTTYmmmxNNNiaabE002JppsTTTYmmmxNNNiaabE002JpphGmGhEAlInK4Ccgna2+aOtpF3GzlmbubouU591v6u2lt6n320++9T771PvvU++2n33qfffD99tPvtp99tLb1PvvU++9T77aW20++2nUd/HZeU41Molrw+WpptXMdLVK2ljrZm8oafRraGcVt3fSNvmjraRdxs5Zm3NUX78lz7rf1FKQpXQmhgsgQ7m5xqsSKoq14tGJDT/+uRIdlacTIkVBUFQyrAhqDd4tGRHQyg+J0fQcPh8WrIiqZUzidHkHD3OLVkRVMqZxKR9DQG5xqsaKo6j4uQIdmzi1YkNa7eJkSLbSvEyBDu7vFAyowGgNoZ+rv47Lynfh1Qi4lOUf5gw2F4YrM3k7T6Nx4fGaN/0jb5o62kXcbOWbtzZDynPut/WeZWyx4dAuK95vxu5YHRY0ub+nUkqCSzizd8NQ1rQT1fVd4wvZzM4yIBoBbP8AnvB928H3P8gbo81qXJaagf250UOaVEt/zjduN6GyikTDKWqSkKT2xbQQa7dgqDBWm2g5JOY5FDEwHVcgWlOCYhUSPqO/jsvKc9/CV3K8o/zBhsLwxWZvJ2n0c/lj5GF0UKQRym3ZTb6Nt80dbSLuNnLO2Zug/fkufdb+s+xGOP4wGOzQfdRIZPPb4Emcvt18moVfMeyoLrIleIkRyCrI7tvSSEgvDjCm6yRxKWGSaRhDFEt1zs4yBsVuTCgu5lbszMCF5YVt30yb2N+IbWW6+MDjt4F7RhjBFroH6Rmy8D8+M13shZnKPP6OOx2Jz4Bj4cGOJYleNWJOiFLGLnYZuwqpD+gKKASAIAB6jv47LynbdqiFvcs/zBhsLwxWZvJ2mx1RGH1K38OD8mHB+TDg/Jhwfkw4PyYcH5MOD8mHB+TDg/Jhw/kw4fyYcH5MOD8mHD+TDg/Jhwfkw4PyVSliqGtR4cP5MOH8mHB+TDg/Jhwfkw4PyYcH5MOD8mHB+TDg/Jhwfkw4PyYcH5MOD8mHB+TDg/JhwfkqTUFBCLOLHQwssdKNvmjraRdxs5ZtB5ohrSnJc+63+qd/HZeU6bcGLZXlH+YMNheGKzN5O02/+Ydyn+cxeLnVJdnQ6exYhxPbhOQb3Bu1WEDI1/5GjSc5EjcTx3hREtSvTmOpV5EOPTKFBbodezFUzkAk5UdPoqQ5HNwnIV8NFYEZzc3JryYyNKyGLVLdeoynVdxLyzLxYYUYMFX0M/aVayPp26ii8RmbXR7QudX+9eIs7CodCXCs9jIF4m8a5BerEVTOxuShXStK0pWnJF3RWS/TJ7NvmjraRdxs5Z1QZu30rXkufdb/AFUjL4qqLlcSkcSf91fRxHq+jiPV9HEer6OI9X0cR6vo4j1fRxHq+jiPVvTCmKQVEFSXH0gwUFVX0cR6vo4j1fRxHq+jiPV9HEer6OI9X0cR6vo4j1fRxHq3NABvdoxUpSZT/XMtFmQlXGY6oOWVRlolqkoszk3oNUkNXSlMxpEN1h6SRY2q8F3MlJYWdmGtQXXHIGJzaqPUnuslBiR+cKOqq7mQvRQljstRXaOhTW9plsgT3du5J5CEbumuykaGrbUpaXckYkoSnIeKQR+bHSruyuwLo6Exx2Zi3hNdq7Iyil6ZyWw+YJXdgdSVZl1MjIbZClQSId2j+ZKETuY+1uadKJUBGcElhJJKKDyR9wVkLAlNRpTBKmhPhJDISAnScoQymUupnRxHq+jiPV9HEer6OI9X0cR6vo4j1fRxHq+jiPV9HEer6OI9WeylUdUYAqujiPV9HEer6OI9X0cR6vo4j1fRxHq+jiPV9HEer6OI9XIW4tuA0HEKus/rJG9zlRGWp+c587wZoRFP9Dr3iADGeljEmlxjE6RxsIZWW/FheTxBIbkV8qJcFaQWyxmVyBzZJytVtrZe1KCSRubjGw3ysVJTRnolkqqTr5+1sDXJW2XTSTOrdDyneaTS8aGmOzCndibxHJ4vQhba0Kes+/XxDlP+yjaLbUPZTlP9NjlErGU/1zLQ3+IRWzltJXjNFTFptRik2oxSbUYpNqMUm1GKTajFJtRik2oxSbUYpNqMUm1GKTajFJtRik2oxSbUYpNqMUm1AlqMNQ0EqxSbUYpNqMUm1GKTajFJtRik2oxSbUYpNqMUm1GKTajFJtRik2oxSbUYpNqMUm1GKTajFJtQJQUMNaFiSg4aYgFkX8nk9pP2x3ln8Kj8271eTLfo2nryOC0fHgh6RPZlyzNuIsM8I7qGdOyuTVVetjSde8MrqaMq5VnA3rGob1S5lHU89WOUR6FEMCB3R0cUd0rSmZXVoG5kXXokb0NxTvEgu+E+vaJ7Tyat0zUWhZym9zS3XNhRgFKx0ZLo2CPYHLlTclMRIkycxV1X36+Icp7AKjfXcpTspyn+mxyiVjKf65lob/EIr+myn22UtspbZS2yltlLbKW2UtspbZT7bKfbZS2yltlLbKW2U+2ylpBsxkX/AG2UtspbZS2yltlLbKW2U+2yltlPtsp9tlLbKW2UtspbZS2yltlLbKfayL+Tye0n7Y7y1G/R2QbK8mW/RtPqn36+Icp+CWFtrv1p2cp/pscolYyn+uZaG/xCK+jf/rYt6RF/J5PaT9sd5aqpWdtNRcqW/RtPUWFGnBJoUqohcKA2Ve6onDerWjvRGvpTznBr60r/AO8URr9tK1d8C4blQ51RGuoPezXAOPD3c8okXUM3s1wLhw9zPKpF3F3s1wDjQG7ndUi+oqizbBL9lKZ1g3D5jBrqVpXOKonCodmchSLgmAHmv6vv18Q5T0ZSiThlCB3acp/pscolYyn+uZaG/wAQivo5KsSELo2E1SAVBBpWlfRIv5PJ7SftjvLUiHR1bd3lS36Np9U+/XxC1a1pStquf/IVCyMyM0eZGaPMjNHmRmjzIzR5kZo8yM0d5UOKvFZ0LeYciPA3o0qNM35kZo8yM0eZGaPMjNHmRmjzIzR5kZo8yM0eZGaNyEpWK2M4CUa8wQBBokYjVTYxsyA5NmRmjzIzR5kZo8yM0eZGaPMjNHmRmjzIzR5kZo8yM0eZGaPMjNHmRmjzIzR5kZo8yM0eZGaPMjNHOYMxz9bFFTq30cRhpsojzIzR5kZo8yM0eZGaPMjNHmRmjzIzR5kZo8yM0eZGaPMjNHmRmjzIzR5kZo8yM0eYmaPNRU2b6cNdtKVsi/k8ntJ+2O8tZw86aK1pyZb9G0+qffr4hY3ujsl+mT+kUK0qQFBqFJJ5CguhhJ1tttttthmFlB3jB7f1o4IBH4ei5Q5NyQ4klS4BOJEYMoJpRxJ4aiKNtUVA0rWtQjAMIRhFWtKU21qSeQoLCaSd6MdKVAKzd+6FJZF/J5PaT9sd5auoqOzVXbyZb9G0+qffr4hYzujsl+mT+knjevkc1ijUiSN8hd2FIYmIVrp/KKurChz90lC5/h7ktpP5LISYcugaBQ9An0gdkq7/APNHiXnOpjeocZOdKnyQIZG2KJegn0oNdTlI5DdW+PDqF+E6PTXWKSyLoANhYFcQeYZJinBM0qHxolDqoIUMCsEAuUj4yTovJpPIjaIKS1XLpE9RhS3OMxlBzqlcY2wMzgXK5lJWF3FSSw92WJ5shjyKQejH3RWbvoEdkX8nk9pP2x3lrNmatFa05Mt+jaeuqUFJE56g0Z96EOTtLk6nvUQvOic5PWJ2dfQQRU20Ftp99tPu5zmPMprsW4rZdN47BWcl0e1rZfPA3gsiqV6oMNQ0rvVEGmzbWog/dhvBjUkcC0Das6z79fELG9grJfpk/pNlNu3ZUooW7tK4RdRVFw6FF020oWIAB7N4CFlbm5S5qk6fhF0qKvDoSUGmyhVCi6VHWhYCyyw0CAASwA7oKElUHUyhe6H2iKAMO6IFAApt2AqUXUVBcPZTbt2BKLBStAlhKLAMQwl+jH3BWbvoUdkX8nk9pP2x3lrK0zNnrypb9G09dQnKVEHJzi71rtyOi6Q2JxaaGzO8RhlxzXdpW796czVZbNCWC613YH6PL0EbZbmHATPGaLoi83dTJ4i0mAujF7MbdZBBYKhjzdL7lzw1ZzjlrtAZOmQmsAIW7wSfnsMCGoipEGnxt6Jbi4tbawtKI6h6Rv6z79fELCDvbbVZxhrWhKrKFOtyhTrcoU63KFOtyhTrcoU63KFOteiVTSzujgFSS2KTSSjMZlCnW5Qp1uUKdblCnW5Qp1uUKdblCnW5Qp1uUKda5gVIFbKSFSJuUBKGZjGMhY6sjO4DU5Qp1uUKdblCnW5Qp1uUKdblCnW5Qp1uUKdblCnW5Qp1uUKdblCnW5Qp1uUKdblCnW5Qp1uUKdblCnWugVaFSzlAVBalAqbaLcoU63KFOtyhTrcoU63KFOtyhTrcoU63KFOtyhTrcoU63KFOtyhTrcoU63KFOtyhTrcpU63JzBUrQ1UGlA0pSlkX8nk9pP2x3lrdtXNpFTlS36Np9U+/XxDlTH+JSeyX6ZPyn+mxyiVjKf65lob/ABCK+jf/AK2LekRfyeT2k/bHeWvqCjky1FXky36Np9U+/XxDlTH+JSeyX6ZPyn+mxyiVjKf65lob/EIr6N/+ti3pEX8nk9pP2x3lraCxzRUPKlv0bT1lAqFkjHW0YUTqQx5imVJmK+NCS/Lmk5uiU7VyNxohWx1TfKyt7mSgWoCr1DxgEsFFXa+gbecwOq5A5Sg1laGZxcWw2+hE6sRypAjJvFnZ7+iSlMMknatTc85ypnpKZRK7rzwGLX1cbN4eni72umTberMDLupLx1kNcFLlFI6vVD6r79fEP0NXpiRbph9HNBrKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLL0XlwRwSSqGMEUd1amPs6l6Mq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyjmiGIIAKaV20s/02OUSsZT/XMtDf4hFbGnlk0qIwdXdB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZebIZShdYP0cQEuSIAKUEtq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosq7IOyiyjmjMFQBamyL+Tye0n7Y7+la7LCdUIBVDVVV2QdlFlXZB2UWVdkHZRZV2QdlFlXZB2UWVdkHZRZV2QdlFk+lEpQSWDpmJrKc0IA/utq7IOyiyrsg7KLKuyDsosq7IOyiyrsg7KLKuyDsosE6oa/tRWUpKNDQRY5Z+6Jo6ww7wa0sTdM0JhkJ82Bc2zFjIrnTfEm9scUK8kb3dDE39VJFK0pdds2KnVUsG4iu4jZqNrRqC1UGb3CFjiStV/iOLBo/1LAjgbQ3v2bgWHQFoPhCmI1NS3btdFapS7uTddgkRqmcax/Kufi5ChpPpSPxtXHzTiQOnVffr4hY0Vdgq0sRShhQDR03Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cD7NwHt3Ae3cB7dwHt3Ae0RRYqVoIDOcM1uSVGJ+2VcYlYyn+uZaG/wAQitn7/qOwix23Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3dB7dwHt3Ae3dB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7dwHt3Ae3cB7RFFjpsEBmNGc1IDB1RfyeT2k/bHf0fxjLQGUCKhZYaUpQG4D27gPbuA9u4D27gPbuA9u4D27gPbuA9u6D27gPbuA9u4D27gPbuA9u4D2tP/TcwUBaV/RNPInjvI0jhDW1kcB3nPwGphFjoNJJgqem5E+PDxO5MQ8SBOvVLJLIH1gobV5h1480e5ExjUlTW8aZtkmkqVnKGick0sMeD16O9efkthKhSN0eZWilTAWOeXcTZ9cVa1DJ3KldvXffr4hY3ujsl+mT/onvZklUTnIT2xde/MmJGso4tiK8+dEvxCF0akt90nSIGl4d2ZdfBMmNAuq4tjrfBMWVa5sCplDe3O1xCYCOPSKfzdzarwV5LnLnd3hCuVNTdL5BeDMHRaRRENVPZoSxTdqpJv8ALMpRIFi4lEVeq5GDbAYKl7U+cY+WeYihKpzXRCMq3M2zH5als++YRGxlP9cy0N/iEVs9+cn8uZTiSt0mExMCVXe3JC1bk4EtgL1rw1ipEWkaT75ZgpQjXtzSbfFIRjWu6ZpKvglKY9EucGZNfjNasi9wPizzeBeGYvTtO+rdX9vj0llpM4bLwpTRzUMbQVdXLH1e8RCjo/xW8udlRhgTJBSq9mXSGMyJUyEqL25ObKT2ZGhbr5J6iYYunLa0Cqq5AiV1J5TD5O3WRfyeT2k/bHf0kP0FbTmWvrO8xhiYk7pe3LiinlQhbj72JupdRltbQkvWnDsUwpkDbS+6TOjUvd2pmNvalVXY80pob79ZUtSuTn0Wk95t4lGR7TiDNpNPWV+kUdIe0ktfl42Z8zZxmErKiboqpI5vP3uLTaXKW4869CcJnBUwGNaC+mWJyEa95Y1d8EuY0yujq3PV6MiIfXVnaW9rvBnD9K4ClENs80T2lf0TR161pSyhM2qjUxxyZIx3dnvjyJMxFNzOnNJNIQDZLvukhlRsjixXdkOrMcuYk0aiqJzUuqNhcY1FXRckXrmLLGMB1DQNyBhu9TK3trRMVGGBIKtDWBmrA4cSQYmRR8HZ1336+IWN7g7Jfpk/6J4FDUjqvdiI2iu1gbclXpEsXHFI4M8Z4miGXURSIJCaUbUV2sDbki9Ili7lCIk8Vcqr2BLCooiLKKTMKi72FKgjCdG0N3UHbW5ybUkXUXewlU75wdGhQCGDrtFHFF3sJVOSJzOjNLvoVR5E9UjRULipJKEgDE1tbeyN6VubktmPy1LZ9pscYjYyn+uZaG/xCK2e/OT+W/wqKSo9Ie9sKiBQ1U9lPh0cJiEZIEkEUymXPQxU/ZisalEChqp7JfDo4CIxkuiOgWRLdrA0JS0lNFV8KijnVfVYxJ7t4IleM5Kiq+7+FuZNSVkbXXawNyQNqBVF3O6aJO743rlrY53cwV4Vlq18WKu+hRDrV2KjZt1t3pyZEmHEgAAWAIAB5TD5O3WRfyeT2k/bHf0kP0NbSGKR2WJyE720L7uYK6GN5iyLVikcqeI+rO63SRF3dmpUpbnC7qDOhrcasixkSjZ1VFTGYu7mDFKXNSCLq4XFF5aotUxCisdGpApGzhiEZCmaEoWUEMigE6hNRhQ3bwVsQLUCSMGROOGuBjiNnKh0XIwlC2NFdrA29E6Ik0Wb4BDGqhNEMc6ExPipTqMLX5ontK6bETR17yCVh8Mfy0xjaUsGBuLemesUcTE8peSm4CKfjkLkYnOq3KaVqujrS6GymQvzi5MzZc+ieinoZppytwfinlQz0RMVJAuiLEqigFaYpOfJTY+xIGqSmENKkhubm59qzPXCV3VuishoTtypr6z79fELVptpYcfBvVqSpyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevyAevowC203lydOWnJKLAF/pscolYyn+uZaG/wAQitnRsKXHBNCZkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fkA9fSP12031pJYCSiywBRfyeT2k/bHf0WJylZRhRgcgHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr8gHr0LSBEZU2pks+iaOvWm224G24G3DDS1Sw1twg2oGlLCKALbts3MqBpQpECIjhhtwg24YbblKdeUrUTefFFKxX04hn9r6cQz+19OIZ/a+nEM/tfTiGf2vpxDP7X04hn9r6cQz+19OIZ/a+nEM/tfTiGf2vpxDP7X04hn9r6cQz+19OIZ/a+nEM/tfTiGf2vpxDP7X04hn9r6cQz+1r5BH3V3iRDc9mU/1zdlIzKWtJGY+kUm9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HV9L2HVsC8Di/yJWRSVKaJiWc4YOl7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq+l7Dq3t9QO1WdIir6ndptrW2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+2yn22U+25TbttWm2mz/wARs/fbbZTbt/8AoX//xAA2EQABBAIBAgMGBAUEAwAAAAABAAIDE1FSEhGhFDGRBBAgUGFxMDJBYAUhQEJiIiMz4YCBsf/aAAgBAwEBPwD/AMVsrkcldTkocj5Eri/6rjJ9V0f9UeQ8+q6nJXU5KiJMbSflpVb9Sq36lBkg8mlf72Cuk2HLpLg+iLZD5tKrfqVW/UqMFrGg/uQq92Ar34CvfgK9+Ar34CvfgK9+Ar34CvfgK9+Ar34CvfgK9+Ar34CvfgK9+Ao5XPd0IHyY+R+Hk0foi8YXNui5jVc26ov+i5jVcx+rUXAjy+CD/k/9H5PWzUKtmgVbNAq2aBVs0CrZoFWzQKtmgVbNAq2aBVs0CrZqFWzUKtmgVbNAq2aBBrW+TQPmRkY09C5XR7q6PZXR7q6PdXR7q6PZXR7K6PdXR7K6PdXR7Jrg4dQflcn53fc+4N6gHkuH+SLei4jZcP8AJcen9y4fVBn+SI6H3ez+T/v8rfCXOJDl4d2wXh3bBUO3C8O7YLw7tgvDu2CPssgHU/8AzKofuFQ7YLw7tgvDu2Cjj4Ajr1JPzL2z+Mye1/w72T2ExNa2DpxeHHk7+XT/AF5+mAuo+SWyblWSblWSblWSblWSblWSblWSblWSblWSblWSblWSblWSblWSblWSbFc5dnIvlH9zlZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVZJuVA9zi4Ek/wBSfIroR+KCR5K16MjyOn43s4PV37cbCXAHkqDsFQdgqDsFQdgqDsFQdgqDsFQdgqDsFQdgqDsFQdgqDsFQdgqDsFQdgqDsE+Ms6fz6/JY/yN+3w8nEnoF1euT8Lk/C6yYXV+FyfhcpMJhcevX4faPJvyVs3EAceq8QND6rxA0PqvEDQ+q8QND6rxA07rxA0PqvEDQ+q8QND6rxA0PqvEDQ+q8QND6rxA0Pr/0vEDQ+v/S8QND6rxA0PqvEDQ+q8QND6qSTn0/l+0aWKmPBVMeCqY8FUx4VMeCqY8FUx4KpjwVTHgqmNUxqmPBVMapjwVVEqY1TGqY8FUx4KpjwVTHgqmPBVMeCqY8FUx4KpjwVTHgqmPBU0bWcSPkhYSfNVnKLHH9VW7KDCD5qs5QYcqt2UWE/qmtLfwvaPJv9UJXj+5WybdgrZNuwVsm3YK2TbsFbJt2Ctk27BWybdgrZNuwVsmewVsm3YK2TbsFbJt2Ctk27BWybdgrZNuwVsm3YK2TbsFbJt2Ctk27BWybK2TbsFbJt2Ctk27BWybdgrZNuwVsm3YK2TbsFbJt2Cc5zvM/1XUZC5NyFybkLk3IXJuQuTchcm5C5NyF1GR7+oyuTchcm5C5NyFybkLk3IXJuQuTchcm5C5NyFybkLk3IXJuQuTchcm5C5NyFybkLk3I+DqMhcm5C5NyFybkLk3YLk3IXJuQuTchdQf1H4x93AqsqtyrKrOVWVwKKZ+Rv290n5z9z8IBK4O+i4OVblX9VWQCqyq3fFB+Y/b3P/I77IMJAKrcq3Ktyr+qrKDHfRcHJrS17Pv8Aj1SYVcqEcoVcqrlVcqrlVcqqkwmjo0DA9z4nlxICqkwqpMKqTCqkwqpMKuVVylVyquVVyquVVyqqTCqkwqpMKqTCqkwoo3NJJx7nDk1wyEI5VXKFXKq5VXKq5VVKq5UyN4c0n94f/8QAOxEAAQICCAMFBQcEAwAAAAAAAQACA1IEERITFFFTkRUhoTFUktHhECBCUHEFIjAzQGFyMmBigYCCov/aAAgBAgEBPwD/AIrDtCDGD4QrDZQiGDtAVcL/ABVqF+ytQv2Quz2AKw2UKw2UKMA2K8AfLQaiEI0OcK9hzjcIvhO7XjdVwJm7quBMN1XAmG6a+C3scN1ew5xuFfQ5xuoxDojnA/3KKIyoVud0WEhzP6LCQ5n9FhIcz+iwkOZ3RYSHM/osJDmf0WEhzP6LCQ5n9FhIcz+iwkOZ/RYSHM/osJDmf0WEhzP6LCQ5n9FhIcz+ijQGw22g4/Jh2j3bt5r+8hDdnUrt0yuzmrt8yuzNzV26ZGGedRTWuBrLvcpX5X+x8nEaKPjKv4053V/GnO6v4053V9GnO6v4053V/GnO6v4053V/GnO6v4053V9G1Dur+NOd1fxpzur+NOd1fxpzur+NOd06I99VpxPzJsGI4VhvJXEWQq4iyFXEWQq4iyFXEWQq4iyFXEWQq4iyFXEWQq4iyFXEWQpzHMNThV8rg/ls+g9heQag1Xn+KtnJXhkV5/ghEOmjEqq+6rwyJptCuqr2Uv8AqZ9PlcOkhjAC2upYtsh3WLbId1jBId1i2yHdYtsh3WLbId1jWydVi2yHdYtsh3WLbplYsSHdRot64GqqofModGbDjPi2iS+vlV2V5fJMkIMKQK5hSBXMKQK5hSBXMKQK5hSBXMKQK5hSBXMKQK5hSBXMLTCuYUgVzCkCuoQ+AKxAlagyCfharmFIFcwpArmFIFcwpArmFIFcwpArmFIFcwpArmFIFcwpArmFIFcwpArmFIFSYbGhha0D9SO1BzSAawqxmFWMwqxmFWMwqxmFWMwqxmFWMwqxmFWMwqxmFWMwnWXCokK6hVJsOG01gqsZhVjMKsZhVjMKsZhVjMKsZhVjMKsZhVjMKsZhVjMKsZhUsghgB/V8slyy9vLJcslyyXLL28slyyXLJcslyyXLJcslyyXLL2cslyyXLJcslyyXLJcslyy+TRvtFkKI5l2XWTUTWuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKt0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuuKs0TuqNS20m0A0tI+S0j8+N/M+62FAsAufzLa6q0RRuXOqrKtXVGABvVZop+I8kWUU1C1Vui2in4yEGUckgP5VdVYos6jNgiow3V5+79l/mxf4D5LG+zryI57Y1m0ayLNa4U7vA8PquFO7wPD6rhTu8Dw+q4U7vA8PquFO7wPD6rhbu8Dw+q4W7vA8PquFu7wPD6rhTu8Dw+q4W7vA8PquFu7wPD6rhTu8Dw+q4U7vA8PquFO7wPD6rhTu8Dw+q4U7vA8PquFO7wPD6qiUTDFxL7RIyq/tA8gVxClE1h4A+gWPpeoNgsfS9QbBY+l6g2Cx9L1BsFj6XqDYLH0vUGwWPpeoNgsfS9QbBY+l6g2Cx1Mqrt8v4hY+l6g2Cx9L1BsFj6XqDYLH0vUGwWOpk3/lY6mT9AsfS9QbBY+l6g2Cx9L1BsFj6XqDYLH0vUGwWPpeoNgsfS9QbBY+l6g2Cx9L1BsFj6XqDYLH0vUGwWPpeoNgqBSYsZz2xCDUAQav1LuwoEVD8KHSAwBpZWAEKTD+7VCqqTI8MDmysrFM0k+kMc0gQwFiWyntrHNOpLX2a2dhBP8ApYlldYhBMpDWtquwSo0URCCG1VD8L7M/NifxH6o0GjE13fUrA0bTO5WBo2mdysDRtM7lYCi6fUrA0bTO5WBo2mdysDRtM7lYGjaZ3KwFG0zuVgaNpncrA0bTO5WBo2mdysDRtM7lYGjaZ3KwNG0zuVgaNpncrA0bTO5WBo2mdysDRtM7lYCjafUrA0bTO5WBo2mdysDRtM7lYGjaZ3KwNG0zuVgaNpncrA0bTO5WAoumdyoUCFBrsMqr/VWmzBWmzBWmzBWmzBWmzBWmzBWmzBWmzBWmzD2kgdpCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCtNmCBB7DX7bTZgrTZgrTZgrTZgrTZgrTZgrTZgrTZgqwewj8ZxqCAVg5BWDkFYOQV39Fdq7P7K7OQRATDWxn09jub3/U+6BWVYOQVg5BXZyCu1YV2f2V2feg8n/9fZE/Lf8ARBlYHIK7OQV2cgrs5BXf0V2rByCsHIKzZcz+QQ/FIrV28fAdwrMSU7jzVmLKeisxZT0VmLKeisxZT081ZiynorMWU9FYiSJoqa0ZD2OhvtOIbXWVYfIenmrD5D081YfIenmrD5D081YiSnp5qzElPRWYsp6KzElO481ZiynorMWU9PNWYsp6easxZT0ViJIenmrD5D081YfIenmrD5D081YfIenmoTHBxJFXKr2PFprhmFZiSncKzFlPTzVmJKenmrMSU7jzVmJKenmrMSU7jzVmJKeisxZT0TWPLm1iqo/3h//EAEwQAAEDAgICDAoIBAYCAwEBAAECAwQAEQUSEyEGFDAxMkFCRJOU0dIgIjNDRVFykZKzEBVAUmGxsrQjNHGiB2KBocHCFiRQU3NwNf/aAAgBAQAKPwD/APgzzaXZhSstOKbUUhlarXTY74rEuuPd6sS6493qxLrj3erEuuPd6sS6493qxLrj3erEuuPd6sS6493qxLrj3erEuuPd6sS6493qxLrj3erEuuPd6sS6493qxLrj3erEuuPd6sS6493qxLrj3erEuuPd6sS6493qmK0spSFpdkOOJKdCtWsKJG+K4iaxHO7GacWRLeAKlJBJsFViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71PuoQGVJ0zqnCCoG9iok060HZbaCWllCsvqumxFYl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9WJdce71Yl1x7vViXXHu9U4qM+KghyS6tJSt0JIIUSN4/aufq+Q54c1OJORg+iSUo2sbtF7JfNfNYVJiM4A+GpMmZo22lhRUAtCgo+L4lYc/DC8hlNyW1shZNspWDa9RGVR0IW+FvISW0rNkldz4oVxXqI9FwlBVM2s6h5aD9yyTwzxClCI9gicVTiS1tJjBpS8mRRzXChUKU7HALzbL6HFNg/fCSSKw+U4SsBDEhtxRKOEAEk73H4fPj8hyuSa5kx+gbvPEXYxPlwpbeVvSuLiWzFsZ7EHNUOEJkaO+lqTIaacSJKM6AoFW+RUdtSIzr7ccutpefDSSohpKyMxqPhrWMRUSIrM55pl0pXxWKrE0qRieGYOrFHIzZR47QuciFKUBpNW9UTDdsxGZOhmSGW3G0vC6QvxrVCj7a/l9K+hGl9jMRmpqQy4LodaWFoUPwUm4P2HkMfkqufN+FJ2+MEGLaeydBoS9oct73z3r6ubh4vLwxQnLbaK3YnDKPGN01AVFeUUtPiQ2W1qAuQlV7E1hzy5d9rJbktqLuU2OQA+NUAYiRcQjIbEjo75qhpbYe0Dyy8gJbd/wDrUb6la941hzb6ntCllUlsOF37mUm+b8KenzNjQZMyKyWwtem/+orUAcvKrD4rqihJaektIWFuDMlJBO+RUGK84grbbffQ2tSRvqSFEEgUhxtxIWhaCFJUk6wQRvg+D6Sh/OT9q5+r5DnhzZUrDhgUjDC20SJCkJWw+hv12S5U2XEYlbFXpERAynEmIca0ptr75z1iWDYRNbwYw8GejCK9JfhvBbrqI9Y7ERjGB4GzAjyo+V95UeSkuWSkmskCZ/h2w1FQzHAZdxJp24CeIvAVicRl3/CNWGNxzELR28JF1M5Ry1cKhg6ZH+FD8SZLCRHZ+sDYlD7hsA4fWqn9jrjOxOW3LLqW0mW4hABeTkJzo9Th4Xh8+PyHK5JrmTH6Bu+Oz5eyXH5knDZ8ZgLglmYpGtx29kZQKm7KJrWwnCMOiKhsB/assxciVnjQCR5SsS2UyJuwOBh2FPxmhKTBmMM5XELWfJEK156xEvs7AosOM81hglurkC5Wy4t5WWNkP3RnNT3HsS/wkRAakoh3KMUQwpK0OnfS6QMlOyWo/wDhHHhRjIjlSUYkgEaNF954VKx9Cf8ADhMFqDdovYdJbJzLeQ6pJaTbztcxX81f2HkMfkqufN+FjGOYVK2KHCljCmRIfZfRJLwzI+6afLM3/EHEcZxGC63n2tEko8QSRT/1Qj/F9czapjnQDDC0RpMv/wBNPMTY/wDi0H4jrcYhxvCUOXCkHiYrE3dl8nZscRj7KwwDGEUvhYe21xAI5FY3LdxPZ81jLE9lkKiGIXGzcL41DJwRT8jGZWyeG9gr4jkvrYS62Vrjmprj+OYfhrmFyo8S6HSjIX0JWOWpWsinpcyThWEowJ5UfOtbrUZIc2v+IIp7HHZexDChh80KaX9UliIEuB/OoFg5/G9aqsRgED5CfB9JQ/nJ+1c/V8hzdW32H21NutOJCkLQoWKVA74IqHAkvI0a3m0kryXvkBUTZPh8+PyHK5JrmTH6B9gabnzmmm5UkcNxDIsgK9nwYc99hGRt1xJCwj7l0kEppqNGjtpbZZaSEoQhIsEpA3gPsPIY/JVc+b3eBOmpSlJfcQcyko3gu3DApKEISEoSkWCUjUAAPB9JQ/nJ+1c/V8hz7Lz4/IcrkmuZMfoH/wAPyGPyVXPm/svpKH85P2rn6vkObkpB2wwklLZdNlOpSRYesGxPFv7nz4/IcrkmuZMfoH/w/IY/JVc+b3NaAy6EJUSLLBQlWZNuK6ra+Mbl6Sh/OT9q5+r5Dm5KJ2zG4LoaPlk8o/p5W9ufPj8hyuSa5kx+gfQtqDDCC6tCCtXjrCAAkaySTRdOP3+ri2kqDiUsl8qJ4k5BW99ItQuN8fQDbwbChakNSXYr0pKFA+Qj2DiyreATmG/WLsM4s7osNxCRCcaiS15SsBpavvAXTmAvSX4+meZ0oBSM7DhaWBmA3lJIoJmy2Hn2GbKJU2wUhargWABWN+hYb9PHbzEl+E6tGVuQ1GcDa1tnjTdQKTxjX4Uh6Ziq3NrtMNFwhDOXSOuHeShGcXJoGxsaG/atZpapOELYRLukhKVPth1IB4zlIJpS4rrrzba1pKMxZcLSiL8V06jQSlKSpRPEALk0va2IR25EfSJyKLbgzJJSaC5cBLKpTQB/hh8EoubW1gUhmLGaLjrp3gkfmfUKfZkw0R1vsPoyLSmS3pEGwJ/Ef1BrkMfkqufN7mxm24gr0ebNfQN+UvyrerituXpKH85P2rn6vkObkgDbcXhtlwX0ybahx+o8R17nz4/IcrkmuZMfoH0KejytkbMqZ4hU2GIDa5NnPwK0JFTUo2EYPNZwWehpbhMfFH28i2rcNcdgKFB6NH2PJbK8Ogyo6J0lDyXwu77i1PPICCCoDjqa1Ex9nC9kGKqXm0TTbDjwagA/e8mFj1JNSHMLw7A5cxxhDLzzT0mS4lplt1LQN7pbWUpNTVtYBscnz8Nwp8uZBInyluxYyxyy0hpIyVNdxXCMFnT9kmMPNPNuuvriKSIzynAM7i3lAhvkgVjbK8J2NSmtkeMsRnzKL0lpDCW1B3KXHGlkuFPICahOx2YcOOjGoDUiMxiCrrUouNP3zPI5TgJ4XgojNoL8wNToT0rDJqkJDYjvhg5s4z50CkQMOY2ONPYdgEyHOxFt2VJcWp1LIbUgl1GpKEr1oBqbjsrA9hOFwFnQuCQ81JUpEp1Kk57qbbUAQCTWMbKdjELB5zsuNiMMuoi6Fghhth9TaFFxR8XJrIFMkYbsURiCWZOHzJQnzZiCXlMx28ic7ZbsXFm6alHGcG2AYHGi4htZ5x1Alu5Zklo2uVMtH2qaYgT4uHYG7IhQ5MRiQudMbaW/mkuLU46hCiCukoi7G8ClrkBHAbM3Iywz8LRNvCkIcwjBsJgonsMrU+0idKVtx5nKLlTTHGKlwsCxdjCsDdkMIeaTJffmpW/IGYAkssAgu1ictDQjRdjeGxmnlnJJbCnZbLpugOl1RK3VG6bUo46nZIWYpXAlOzsPhQ37NOIfLiGkMqbRmKuXmrEXdlGJbIp7sKCiI8pT4U2hmItCwnLosiBdRNhUvFpeBbGcNwbC4DTLzrUjEC0p99TeQZNKFvJuo8AVieJ7LIUGHheBIDT7gZBjNoEtlaBl8solxyksPQMYw/BI+eHMkS4kWM8hkSm3RlajNrF1AgHNX1a1i2z2VGxqW7EkFAhxGbNNO6LIssvuIzEg2N60GD41stkYi3DREchxw3h0O7YaZeWtSW3XUh0A1eGkQMJZXxOOQg4t4j2VPZK5DH5Krnze5vZdOnJnSAi2iT5MjfTf18d9y9JQ/nJ+1c/V8hzcnb7Zj+TWG1W0qb3J4rb44xq3Pnx+Q5XJNcyY/QPCImT2Y7MhwqJu3HzaNIB1ADOfoL0V1balthRTmLSw4ASm2q6d10saQnK4m5SdRuCCLEEEXBFZXJslUmS4SVLccVquSbmwAASN4AADcyg4hOcmySVFRW84Akq1/gkADwFFcKQX4ziVFCm3C2pokFNuSsiksRmEZW0C5/Ekk6ySdZJ1k1yGPyVXPm9zazGQ2V5FlSr6FHDB4JtvAcW5ekofzk/aufq+Q5uTNtuRbaVBWm+mTawTyr8E8R3Pnx+Q5XJNcyY/QPsaUlZypBNrm17DdVsklQyKsSMpI4vX4fIY/JVc+b3Ny2lRlzNhKbaMcBQ4Y9ZO5ekofzk/aufq+Q5uRxYysSYiutIeLK21urGiWVZVjREjK5SC7kGcoBCc1tdr8W5c+PyHK5JrmTH6B4TV04a2vJlVpLKcUL34JTq/rureuZ4uZsuG+iXwSOAf8x3VnLpXvI5sl9Iq/C139f4+HyGPyVXPm9zRcuNE2dK1eTG+nkf87+5ekofzk/aufq+Q59D4LqQsJbWUJSFawAE2qX0y+2pfTL7al9MvtqX0y+2pfTL7al9MvtqX0y+2pXTL7al9MvtqX0y+2pfTL7al9MvtqX0y+2pfTL7al9MvtqX0y+2pXTL7azqZdyhZ3yCkKF7ceuufH5Dlck1zJj9A8KUGdoMBKiUlgrDi7hI3wsC1+Ii26u2EvxsiwgW0a+GDwk/gOOx3V7NpHfLJCV2zm2pOq3q/Dw+Qx+Sq583uZtdo+SyDg8S+X/xuXpKH85P2rn6vkOVxGvMN/pHg4tPfYjNyppgRi+mKy6vIhbtjxniFYntb62+qfrXQf+lt7/6M973vqva1YvDivwZsuNLkRsrT6IHlw2QoklFYpIBxPD4uV1tORbc1VgtC21lJV/lvcKrGUow3EmsOkyDGAZEp15DAbC81ibrvWJzZ7GLnC0QorIW8++hkPqLYzAZEpNyTU+Lg42NLxd2Y+wW3WihwoKFtk+sZfarG4D8VMNwwpEYCQ4zNXo2nW0hRzJJqTEMhpLm15KNG83fkrTxK8HzyPlprnx+Q5XJNcyY/QPCZz7Sb5Z0ts6t9O8E+o7qzfbviaRJUc2hc4Ft5VuM8V91Zy6Z/ySytN9Kq+s8fr9R8PkMfkqufN7md5nzubknkcj/ncvSUP5yftXP1fIcriNeYb/SPBxbBXZsRmLiKIKkIMhlhedFlkFTauLMmsS+qvrz67+pv4eh2/v58+XPlza8l6xFH1FExWOw6goS4oYnfOom2oo5NTEyZ7+HvbZYjRo4bXh7mkbVom0BClk8JRqchWL46MZMtIbDjMoLQ4CgWtYFusWTjQxleKIxUtsKcDzzIYcSW8mQoUBWLygcAdwaYqQ4l12U04su51rWCQtKzcWrE8TnL+rm25bqGUFuPh72nbZSlCQNauEfC88j5aa58fkOVyTXMmP0DwnMu1WrAtgIvnXey98n1ji3V+22vH0ZATl0a/KX3039Wu9t1cJ0r3lGw2q2kVbxRxeo8Y1+HyGPyVXPm9zTfIxezWU7yt9fL/wCNy9JQ/nJ+1c/V8hz6GXW0DKhZcKFZRvXGU66Y6Y92mOmPdpjpj3aY6Y92mOmPdpjpj3aY6Y92o6EBSU5i8d9agkDgcZNMdMe7THTHu0x0x7tMdMe7THTHu0x0x7tMdMe7THTHu0x0x7tAuOrzry8EagAB/QCufH5Dlck1zJj9A8JGbabFzpSVWzub7e8B6lce6sX28cmkzZs2gc8nbl29eq191QBp3+A6XR5VXKP+44t7w+Qx+Sq583ubmXRMWu4CnlXyo30/iePcvSUP5yftXP1fIc3J7NpWvIpSpdtIL6larev8Nz58fkOVyTXMmP0DwlW2qxq0VhwnN5zlezxbq/bbRz6NKSnLol+UJ3k34xrvbdSf47++1oT5VXJ/549/w+Qx+Sq583ubWba8e4DZDlrrtmUdSh6gN7cvSUP5yftXP1fIc3JnLpmPKrKE30qbaxx+ocZ3Pnx+Q5XJNcyY/QPCiLkqbbZDCZaFuFxkuFaNDe6SkayePdWb7dOTOspVfQOeTA4SrcR4rndbfx5HndN51XK/45O94fIY/JVc+b3N7JoGMpKgW73XfKnfB+8TuXpKH85P2rn6vkOfQnOk2UBdVj+Nq/tV2V/arsr+1XZX9quyv7Vdlf2q7K/tV2U5hGKsymltPhJKFNk5XErSoEHxTmT/AJgKde0DKG9K9nW4vKLZlqIuVHfJr+1XZX9quyv7Vdlf2q7K/tV2V/arsr+1XZX9quyv7VdlEhqUpSyEK8UaFYudXrNcR5CuyihaIrKVJKFXBCACDqr+1XZX9quyv7Vdlf2q7K/tV2VbFcSgsxHl5FWytG5I1b6tQPs1/arsr+1XZX9quyv7VdlAf1Sof8UFJULgg3BB8Ny22zmyNhYtoV8MngC/GOOw3VJG2JPBa0Q8srk/88rf8PkMfkqufN7mxpNqRSrKDpbZnbZzvZfu2/HcvSUP5ydwQMt73UNVhc0y4eMIWFED/T6UlSDZQBuQTxH6GWirezrCb++kEqTmSAoXKfWPpSlKRckmwFIXlNjlINvD5+r5DlcVcJpKj+JULk7kPBFxvi/0gbv4qZLgSPUDr8NBO3FWzOlBvoHOCBwz/lP9eLdXL7YkcN0Om2lVbxhxeocQ1eHyGPyVXPm9zf0e1mMt8uivmcvk4829mvxW3L0lD+cncMSedbw7ZDK0DhbLROIsDOng3sjRjJWE4c7JwHEpUR/DHXVyMSdZw4uoamJUEAZ6iy1jYwjEUm8FbsOUX0Ishti5DZCiLOjNSZAYmbHwMaehsoMBnE82mcKEDKUoy6s1Nz0Yts1YiytkjSYrYLbUEEZS7/ASpZFs1RozcnDsRlzpEdiPIExuDMShFim6UKWk5VFNYbshUvAMUXtDEHzHYNlI8fMEL1ppOG4rh2wrHZZkRWxKS2jbIdRHb2wOAmgxKj7HMGmTImgiNsvPyz4xu8S47mHJaACaTIgHHXoESBDRGebVlZuhh1pWSS25ffd1oqNNw3ZFgU04hDvCDsJebICy21dYSOCQ9SwJ8lD72a2+20llIFvwR4fP1fIcriNeYb/SNwhvqfxfGYitj4ZTp0NYcxIW3ZQOfMsspKvaFqEZC14DNVKRtQLZMjEGm1IAYdc/gkKuM+vUQaYRssa2S4inCVtPWmqkiRZhsISblKjqKd61NtsoxbE4G0liKEobhpcyup/i6YuHIFm6cpSajTH0bGMOxaetMYN/+q7JJfZQATYIQSQaREjzMOnYvDeyRUgxkPZGEL2040MmSy3Mvj+NUOAWtluBRfqRKElxYLjDxWHCcxuVEjiyCsOnOYhjD7UfGIchbOLB1/OMs2M6lWkQjljMMtqVKehbHIUyUXURsq3H3FJyvLdcC16kZbNjNffNOvCdsnxBOnAilcZpiO26hpvbK0IGfNx8STasCxJ9WxeI46mW8tDIUZL6dIzoQ6PHAqHh2HM4/DwKOBHSUQm1x23S6Vr4RuciAdQJqMEQGscWMRTEQ5twYeWdGQL5RrcKFlNRMWVI/wDFsRbaWjajV8RlOJXHJQHDov4W+QTWGYCnZHj0aIiHEK5zEVtqI+464jTJaGkcKBxWFqiPyJLWOhWE6BGaD9Xx3nG3CR41wpoBebUc1YfipeYwyQJjSWGVIMpTgcjslZLWcpRmbDlKee0shl1amksqK2HlNEFKFOJuMtiUkpO+Nw50v8h4ZH/tK3mtIPIr31eb9r/Tj3Vq22pXkmy2m+nXfUrjvvnjOvw+Qx+Sq583ubOfacXNZSi7lzu2zDeCfukfjuXpKH85O4JWhxJStKgCCDqIINRv/U/l7tp/g6reJ93V6qgIRL1yQmO2A6d+6wB41RXRJQESM7SVBxCd5K7jxgOIGoG1ncukY2u3o1ZBZOZNrGwFhUZosNFplSG0pLbZ5CbDUn8BTSn2klKHikFaEq3wFb4BplboaU3pFIBVkVvpueSeMVhyy2zoUFUds5WvuC41J/CoSZgFhKDCA9YC1s9r1EjPPm77zTKELc9tQAKtw5+r5DlcRrzDf6dwmSHm5Dshll0tlDbrqC2SFBAcUAlRCQpRABqEhqSrM+2lhAS4r1rAFlGoaJJJJfSygOEnfOYC9RdtOIyLf0SdIpG9lKrXIpm2h0Nsg8n9z2fwqK+iOQWEuNIWGyN4oBBy2qKuUkJCX1NILgCTcAKIvqNQ0THOHJSygOq/qsC5qAooStKLx2zlS4SVAat5V9dQnW3VIU4hbCFJUUCySoEaykahTaFBAbBSkA5E7yf6DiFMOtSDd5tbaVJcNreOCNe9UdtttpTSEIbSlKUK30gAaknjFMXAbAOjTqDRuj4SdXqpKy2rOgqAOVViLj1GxtTLSsWhvRJclltCH1NvIKD49r3sahbWeIU8zoEZHFfeWm1iabZZbTlQ22kJSkDiAGoDcNRlOf8AA8PnSvO6PzK+T5z2f9eLdXs22JHlVJUq2mVbWnk24I4h4fIY/JVc+b3N7JtaPlugBu+Zy+VW+VfeHELbl6Sh/OT9q5+r5Dn0PN5iSUoWQm547VJ6Q1J6Q1J6Q1J6Q1J6Q1J6Q1J6Q1IWrO2nKX8gspYSTc+oGpPSGpPSGpPSGpPSGpPSGpPSGpPSGpPSGpPSGpPSGpOV6SULGkOsBpavzFSt7/7TUkrdjNLWdIRdSkgmpPSGpPSGpPSGpPSGpPSGpgShttYdLviqKyoFI47py6/61J6Q1J6Q1J6Q1J6Q1J6U0EoSLADw03MpVrtFZ8iveVyD/m/03VjLtuX5EKCb7YXfhcq/C/Hw+Qx+Sq583ubebacW9nCV2zu2zI3kj1Hj3L0lD+cnwIMjDdizoTMecxLQPuJ2uiSotNlogkBdgCqgAZzUFQKSCmU8EqSyf8xzig8yZBYQWmXXC44lOZSW0pSSvKOFbepn6qUwl8TAboLa+CU2ve9ZGzMMLIth1L22QjS6HRFOfOU6wLU26mVDfkxUpSslaWNSiuwJbSFeKpS7AGskfFX4DboKydCJic19QJWR6gLmlKZkuvNNJQw8t4rj+VBaSkrGj5VxqptSpzUd1haELW1klamSpxIKUBzkZiL1tdcpDq47SW1urcSzlzlKWwonLmBNNWlR2ZDbiErW2lmQbNOOLSCltK+IrIpTIkLUllCGlvOOFIzKyoaClEAayaiiAhuCuK8ytbzj+3UFbYS2hJJKgLpy3JFCMw7iE2NFCA48t5uGvIp3IhOZKRvquLJppGHFttxMoHMhaXbBGTLfMV3ASBv0ZzeJ4g9GfOR5CowjNF53OgNqVnAFgggU1hsjFIiZYjDSuhhlasqVOryJyJ4sygE0DKipcztIbcUnSIb0xZCwkpLuXXkvmpcd3FYkWQ2ytpw6LbRytpeWE5UFShZOYjN4HP1fIc3Ju2nj+UaLqfKpt4o4/UeI69z58fkOVyTXMmP0DwmNJtSLmy30ts7ts/Fl38tvx3Vy22VZsrgQLaJfCHLH4eux3V/NtiR5bLmy6VWXg8m3B48tvD5DH5Krnze5ry7Vj2u0Am+dzec31H1p4v8AXcvSUP5yfAwnEnMSxJmVEW9HQ64yhqO00E3WPvIJrC04O9svjY+VK0m2v4SUAsBIGXfRcKqO9LwGJLjPMibKgNOplEKK0vRSFgpKaYjTWUM3cbW820sh4OuoStSnHUBesBdyoVBDSdkP1qGkSZMpwA4cYRbLkm6lkGxzE1hDq8Xg4jClCXpAlhEmY9Jadbyg5yA+QtFMBeBzcNfeUb5ViGmxCKiqiycUxOUuMZcmIBtzR6Nalxcq1lGQ3buAawyO/Aw/DIbmJRpUpl0IgmxC2QNHJC0jUHLZKbSzAwrE4i0K4ZXNWwpJH4DQm9YSuJjmDQsPxKS6XNLH0DO13FMJAssKRwQSmyqiPrgLcP8AGlyIL6CtGULZkxbrQRxixChUHEMVw/6tWNs5m25Co8V2M9nKQSm4duhVjWHPz3F4rtiO3NmwGEifIEhKkLjELVkOpSVcKmmnsHcgPM2ceYacXDIJRnQsuoSriIJIqIw8jFpk2S2iTJlanoKoaE6aSpS3FC4JJtUOQmRsbw7CJ2mmzY7bRhoLZWGoy0B9CwrgLrCRgcjFZmI6ZxCnJl5SSdDlIyjKtWpwG+WsMiyIWHYXDexGLKlNOBEA2IWyBo5KVp3g4BkJqMFh93R6DNl0WY6O+blZeFxX+nn6vkObk7fTMeSWG1W0qb61cXrHGNW58+PyHK5JrmTH6B4QVmbabbRmbyF1suFxKLeMVpA8ccQturAKZKiM6SpQuy5wSOAfxPFcbqzbbcvyKlKTfTrvwtea/CG8D4fIY/JVc+b3MfykfXpbnhueb5Ptcr/TcvSUP5yfAyuMw3nEHfspCCRTQ2WB1QkP6JFgwwxt8v5LWstkpT7SqbUt6ciC0dusbYU8trOlZji6gyd7OaeQqVg31jKzkf8AqEuaEMOf586V/DTy8IRsrlYS3iiXGhoruZGhohrLYNkldIaTPiPSoS0S2JCyhoi4fbbJLKyFXANSl4ZhOLRcPn4kH2xlXKDeVaGuEpKS6M9JG12MTdbDU1h58/VyStQfaRcs5wLop54pwfD8RBzhLaUznywA4rkJQU3WuoZmTm5bwQvFYqIpZiqCCtuSTlcKyoZE1KeYjQIjz89S2kmMuYEuJSGlXzlCVArrWBc0hnEmYsaZGRHlx5iy2qY0wtl4IOVt457Zaeb2QmWyyzA202WVtvtLeDxfAsEJDSgrVe4qU7iZYxFUtlchpDcReHOpZcCl8sErGTLUdU9WAR8VxFsTWGCG3gbCMh0guuKCCQinxhZ2U4fhT2KlbVlFb6EvJDR8bJrKM/3qdxaWxhpxGWkPIYS3GzlCbFd8ziyk5U1J+rmIcWQrEXXEJSTMYQ+0gN8LNlX43gc/V8hzcmcu2YvlkqWi5fRbUnXe/BPEdz58fkOVyTXM2P0ClvOKGbIi2pO9clRAFPfG33qe+NvvU98bfep742+9Uj6wxKE1GWnM3kQU8NxOvhOAJB9mnvjb71PfG33qe+NvvU98bfep742+9T3xt96nvjb71PfG33qe+NvvU98bfep742+9T3xt96prRwd5Sn46HUhuY3w223gFaw24AsU98bfep742+9T3xt96nvjb71PfG33qdZUu4QVlJCiBe10k6/DevtmT5VAQq2mVbUnk24J4xY+HyGPyVXPm9z5ox5q3Lc85yvZ4v9dy9JQ/nJ8A5JDS2l238q0lJtUwGTscRgSyHR/LIATnAtYOkJAKqxZsJxoYw3FQ40GUy+UrWgqUFeokgU1GnY7iz0xyO06XkR2lKJS0lZCeNSln8VGsTeiu4svFXMMcdQYhmL5dsuaw4k3tesTfYiRlxoMR91JYjMrIJSkISkqIsACskgVNEGfjkbEEYcy6kR3hGaaDZeBTmBC27kA2NYs7GjCahiGp1vQoanJUh5vUgFVwvhElVY+uYuHDiNzFyEaRpqEsraSkJQE8ZzBQIVWKxMQ0ktT89hTKXXhMKC6lSdHkAu2CLJFqxiJFlsRWZ0ZmQMsoxQEtrcU4lSs1gAogjNTktmfLfW2hSvIsOpCQ0k6rAVjjzbWGpw5kF5pGjjNuIdQlORsWKS0Dm36xdeL7cblIxhTjW2kFpospQBkyaPIsgpy1LekJiTY7rzzgUp8znkvvOuWAusqRWNRgjDm8OfU082lciIySW21qyXBQFEBaLKtWKMxRi7GLfVzbqBFM1lQVpCCkqsopuU3tWJ4bJVBVAkOwnEJL8ZSivRrzpXvEmyhYiltNykxUlom6EJisJjoSj8MqB4HP1fIc3J/Np4/kSAu2lTfhcm3C/Dc+fH5Dlck1zJj9ArmzH6nPBSt2GtKJCBvoUtIWAf6gg/Qloyn0sMBXLdUCQkfiQDTMbRRFy3C6rKEsNkBThJ1AAmg8802l1bKm1tOaNfBcCXAklB4lDV4TbKC4hsLcUEgrcUEITc8aiQAOM00IsF51mU9rytuMqyLSr2T9CdtaDT6Lj0ebLm/pem0PPhZabKgFryC6so47cfg85b/Pw27bbl+TcLovp131njvwhxHV4fIY/JVc+b3NVjEa86Cm4WvzfEf83HuXpKH85PhsRBiciVtp1xjTq0UdnS2bBIAUahtMYlh+JvR2pu1o7EdyMklrIsPFxYBFnc6RUmJLh7KsOEpl6G0y6WZMZ5QSpTK1NuNqLZykUh+NJ2MY5imHqditNNAwEZ2VMgOF1SPvaQCm8Rkf+M4SpEYRg1HbdmznGc4QVjU3fjIvTEGRJxcx04pJYjl9DQiGSWlsMurQHSR4tzrTTL8gO4+TLbuGlqE14ZxrNk1BxbD8NRg8/EJbccNaKFOdWw6nxVEWbsHQrfyg0EGfg2KyYSUJyFERbazHv/myWJqDgqRg+Jvk4fMW/wDWDjEIvJYfRkbAGrODrpvPMwuDJhPLjRy4h+XIQ0EMssPr0jawvxFLtrGs01h8o4/LhqxJ+Owp5LUaG3KDZbaWtrTKLnwioU2J/wCPYWobXGSIpxb77elbzHVco8Pn6vkObkxl23E8tfLm06LcHlX4P47nz4/IcrkmuZMfoFc2Y/U54E5bbbshTjbMZ+SwtRRZAeRFWh0H7ixcA1isbFxiexpTCNO6spaSIyJXGA54uYOKNY+3sg+qMZRjb7heQ1IeW0sMBlazkWS4QWsnBTWLMNIxDC1wTMYcZAW3GkhbmRfBAWpIUax5TsbA4a8SbxHTASpkeaw+80gvmxWsIOseKqsUYQxEaRInPR1xJxaXKaL8WKFALN2kqKiOO1qxuPsVcxdxbcZ5cmOQ2ICgvOFEOJaU7ayTx1j6FTcEgDFlCQ+X1yziLCcgKlXS6UKUkAVsjVsMOISSxBySjIDhjshCy0DpgyXA5lB3lVjSsShbHcOOFDbD2ZMlMiQveQqy3koyBdYmJxl4qpxbcaTolw1MuiOjTKe0JRrRkShGcLrGpTBw3AJc5BekvuLlsTkF9VsxOlDd7gVijkzF8ckuw30R1mKWJr4d0qn+AgIBOYE3rG/r1GyTHEmc6p7aIhoU+hDYUsluwXlARvhVbJQheBwY09cwTCrbG20qfUkA6Ryw1uBs2WKxVM2HKx1vCnXGJDLbG2YiFRVZHFryNZwbZibViDcU4fHS61JiyWEmWCc6/wD2nnVLc++pNknwOdN/n4a77ak8NoNG2mXbxRxepXKGvw+Qx+Sq583ubebabdxozntnVvr4x6k7l6Sh/OT4ba3mCosuKQCtvOMqshIuLjUbVhrUiehaJjyYrQcfQvhBxQT4wVxg1hTEXbCJOhbiNJRpm+A5YJ4aeI1gyFvF0urEJi69MkoczHLrzhRCqhyHTFVFLjrCFqMdetTV1DgHjTWF/Vpd0xhCI1oNJ9/JltmqG3AWlQXDSwgMELJKgWwMtjfXUfBImKEoxBMCMy2X2XBlcQfF1FQ1Zt8U0YW19AY5QC2WsuXIUnUU21EUw4qGSYxU2klklOQlu48XxTbVxVhLUWeQZcdERlLb5BuNIkJsq1YOYrqm1OMbSZ0alNAhBKctiUg6qw5am47cdJMZo5WG1hxDQungJUAQN4Hw+fq+Q5uT19sx/IpSpVtKm9wrk24XGBufPj8hyuSa5kx+gUEh2O2EE7xKFKuP7hSffSffSffSffSffSffSffSfeKT76T76ZebC0LyOAKGZtQWlVjxggEUn30n30n30n30n30yylbrjqkoASC44orWo241E3JpPvFJ99J99J99J99J99BS9OlZA12SjWSfDH83K3nS959fKP6eTveHyGPyVXPm9zdybVTr0g0d855G/m/HcvSUP5yftXP1fIc3Jm224vlVqQm+nTaxTyr8EbxOo7nz4/IcrkmuZMfoFJWk76VAEVH6JNR+iTUfok1H6JNR+iTUfok1H6JNR+iTUfok1H6JNR+jTUJMRmI28t8BF2ipSh/ESdYSbeKR6jeobpjPFl4JQg5HAkKyn8bKBqGpxsArQEIKk5t644r1EdbN7LQhCkmxsbEVH6JNR+iTUfok1H6JNR+iTUfok1H6JNR+jTTbYO/kSE393h87lea0Pn18n/tyuF4fIY/JVc+b3NnOYQ5KtLYL+9vZfw3L0lD+cn7Vz9XyHNydvtqP5NsOG2lTe4O8n1niGvc+fH5Dlck1zJj9A3V5KVRWQCEBKQSXLlC98q9Y4qxST9cyBJlNzXw+NONRcSbAgqGo1MiS2sOti8sLLDUttY8RlskEKc9SqkYdHS0QIshBQ6hYNlZr75vx8f2BQO2pXCdDp8svlD9PJ3vD5DH5Krnze5v6Pax406LNmHFv5ty9JQ/nJ+1c/V8hzcp+JszcTjxkCGRnTILgU2ki41Lsa0a1IBWi+bKSNYvx23LenH5Dlck1zJj9A3WexIw6IyuTNWsGOWiVloo9sK+xKdUhBUG02zKIF8ovYXNSAxFnPNOOORjGTplrLi2wlWsrbzAOHeKvD5DH5Krnze5saQwl239LlC073Fl3L0lD+cn7Vz9XyHPoYabWLoSpsrVlO8SQoVG6FXfqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqG4ErStIXHKgFoOZKhde+CLg1G6FXfqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqN0Ku/UboVd+o3Qq79RwWHS4kBlViShSNfj+pVRehV36jlLLSG0ksquQgWF/HqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqEHXEJQtwRyFKSi5SCc+sC5tUboVd+o3Qq79RuhV36jdCrv1G6FXfqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqN0Ku/UboVd+o3Qq79RuhV36jdCrv1G6FXfqN0Ku/UFhDjzr60txikFx5ZWtRsvfUokk1G6FXfqN0Ku/UboVd+o3Qq79R3QkXKA2pBI/A5jV0rSFD+hF65DH5Krnze5vZDGcvYDRXzJtc7+b1DcvSUP5yftXP1fIcriNeYb/SPtcKNOfSlTMZ11KXFhRIBCT7JrCnI0RxDch4SEZG1OHKjMeLMawz6uEja5ladOj033PaqLhkeRPlRIxlPITpjGcLZWix1pNQnMRKM4iIdSXcuQOXyjiykH7XyTXNmv0iuQx+Sq583ubWfab9rrIctnbvlTvFPrO+DbcvSUP5yftXP1fIcriNeYb/SPtcVEefsOdwVhwgqkMPuuKJdSCLAAKrCEPhGFRkqEyVJDzEGSh5ebSpAQCE+IgCsEfWjZUvFYsCUpxLC2XYgjqDhSg5HARcWBrB35AYxSLJiJlSYsZLc6SXwpBaRmIF7KbqE6JkbC2Ia2gsuoRCihhYJcuQCd4XP2vkmubNfpFchj8lVz5vc3Mu1X72bBRfO3a698H1Dj3L0lD+cn7Vz9XyHK3xUjM0kIuhpbiVBOoEFAO/UvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pfVne7UvqzvdqU2jMlOZUd0C6yEgcHjJqX1Z3u1L6s73al9Wd7tS+rO92pfVne7UvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pQLisqAY7us2JsPF9QqZ1Z3u1KWhaQpKhHdIIOsEeLUvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pfVne7Uvqz3dqX1Z7u1L6s93al9Wd7tS+rO92pfVne7UvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pfVne7Uvqz3dqX1Z7u1L6s73al9Wd7tS+rO92pfVne7UvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pfVne7UvqzvdqX1Z3u1L6s73al9Wd7tS+rO92pfVne7UkrUCEhbK203/FSwABV9G2lF/ZFq5DH5Krnze5ozbTk2u7ZVs7V7N8oetXFuXpKH85P2rn6vkObk9m0jXkUhS7aQX1K1Wtv/AIbnvzVfIcrkmuZMfoH2N222vGyOBAto1cMHhJ/Acf2TkMfkqufN7mbGJI1aK44be+5yfZ5X+m5ekofzk+A6NE6lxORxbd1J+9kIzD8DqqdbRuN/zj97OG515739R308VTNamlfzT1rtCw5W994byuOpm86P5p7zvC5Xw/d4qmawyP5t7zPB5Xxfe46mXC3VfzT1ruix5W8OSOTxVNto22/5t+9mjca817+s7546l30q3f5l62ZYsRbNbL6k7wqdbQpa/nH75UqzA3z3zetW+al305ettl3LmIy2tmtl/wAu9U62gLN9uP5spVmvfPfN/m36l30yXf5l3LmSMtrZrZfWneNTraJbX84/fKs3Jvnvm9St8cVTLlxtf809a7QsNWbe9Y3lcdTeC6n+bf3neFyvhPJ4qmea5095ng8r4vvcdTNRdP8ANPed4XK+H7vFU22RpH82/ezXB15t/wC8d9XHUolLy3QDJdKczgsQQVWKfUneHF4HP1fIc3JrLpmPKrKE30qba067+r1nc+fH5Dlck1zJj9A+xs326MmkSVHNol8C28r8TxX+ychj8lVz5vc+aSfO25bXm+V7XJ/13L0lD+cnwkRyYz8kXSpR0McAuLOUHULijGlxAyZIMSSW2Q+gLRnWlBSm4NIWhxIU2pJBCkkXBFA0hmVHcQ3JIZdWzHW5wUvOoSUINJ1i6de+KFClpjR8mlU22t1QzqCBZDYKjrNMvv4c8lmW2g3LLikhYSv1Eg3oNzG8RVh6g5FkIZEpC8ha0pRkvekPssTH4jisqkWejrKHE2WBwSKGqkkeu9FjTRpMluzTjuZuIjSOn+GlXBTrtQUy+0h1tYBF0LGYGx8Hn6vkObk5fSs+TbDiraRN/FPF6zxDXufPj8hyuSa5kx+gfY38URimICIhTD4aDchSTlD90K/gkXUSNYKa121/Y+Qx+Sq583uaL7Ulai0SrhtbznJHrTyv9Ny9JQ/nJ8KNNWmO9HRpkBVmpAAcR/RYGusQwDY9iiMKj5WYrS0TmG4gQpLbjnByViqJrLkCLgJ0rgDkEMMokBgZkpUpSUWNSMAhvT462o2K4MtDdkNEObXZdlOrRmNrk1iGyWVjeyOROhPhlCsOmMyyCNsvKuG9HWOObJ3dkcF3Y9jcUr+romGoyeIV5glCUAKCkkVi5EzZ/jyMRWXZCArCXAtbOaygAytVYy43A2HbJG2kLU+koliUVQ0Egi6rWKAaxsrxPYLgjkoEvOqdxVM5BevmJOlCKmRNv4ixIiTFpXoHmFNJzBCySCc9Ylh2DL2fT8SRg4itoEoIfDrTulUM+RdYojFV7PsaXMUFupvhrpdLdxfKlpdbJcP+s9iWJMS0R2Hm3BNL6FAaSQ8rTOZb2X4oO8KxFrCkY/hb0vLDlMuTIqG1h0bRW+FHKrLnDahnqY6NuzhBYxKNoHGIciwLSWy6+pDZ4go3tQSlIASkCwAG8B4PP1fIc3JFtMxw3S0PKp5X5Dj3tz58fkOVyTXMmP0ClJSlCVHKbElRPZT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7adNjcfxF6j76e6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbT3Sr7ae6VfbTgUBcZllQ/1Bq2ZIPvrkMfkqufN7mvLtaRchwBF8zdro31H1Hi3L0lD+cn7Vz9XyHNyIOlZ3mtMfKJ5P/PFv7nz4/IcrkmuZMfoFeab/ADVuQjrTH2w5ZpxwNM3tncLaVBCSRYFVrmiZLRWghDLqkF1CNIWUrCSku5RfIDmqEHcSwNrFUNYrMMBS0uqKAywChWkcBT7NOwJ7rURT8R1lxRiql+TQ+tCShFycoJNiaKDDblLdcUw6GSIYJfCHCnIstgHMEkkU4Q0plOi2s+HnNseSLTRRncDljlKAQaUIS8LTORLS08uw0y2XA6hKCWw2UeOV2tRMhtZbJQy6tovBGl0IdSkoLuXXkBzVh7TD2CN4mTis/aC7LccRo0BTasxGjpcJ/EYUWUWHG1q2umVqbD60JKW8x1ArIvTsVEfFpUGI2hiS+++mJqddLSGrhKeMi4FMnJARPUtCVrbEZ1OZDhWkFNl8n10qR9YYo7AfDiVx3YzjcZUnx2nUhQJCRYGlRtpz2IUYoQ4+uS69G2zlQ20km9qTMUMMfnMMtocOZLVwA6UpOhBWMl12104JSSUEJYeU3pUt6YshwJKC6E68gOanYYxKEiWGnGHSphpRyZ3ilJDaM2oLVZJrUdx4jXmkflXIY/JVc+b3NrPtWVlugly2Zq+Ve8B6xx6ty9JQ/nJ+1OIS9iy0LyKKVWER5W+KndZc7an9Zcqf1lyp/WXKn9Zcqf1lyp/WXKn9Zcqf1lypxOmZFjNW1vuDlX/246ndZc7an9Zcqf1lyp/WXKn9Zcqf1lyp/WXKn9Zcqf1lyp/WXKkrDmJrQoOOqWMu1XlbxPrFck1NLj2GRXF5X1pF1NJJsAaeWNE2burKzyuNW5SHVbJdj7WHukwVSGitBcQAl1CwGTZ05i4LVGcg/XL2KgKD6nw69dWQAuaIALVcKy3rY/isWLhDGHLi4nBU8wkxwUIfaGa4WpNs6TWm2zFwdhLzjZuPqwgknXy7UxiMhEHHAygpkOSZCZ8d1CGhncKEFGYJAQADWDvzNqQIzMfariGNFFUpwlRC86HSV3CkEZKEl/Edjr2FBxYcc0WkeedFlOqUtaEB0JGY3NqiHBWse+ugkMqEsvX0miKs2XJpDe9r21VsblmPgbWFLE/DnJCcjLri0rQNILEhdlCmX4z0ODHmqkpfzjauolpDbiUELTqCVg5agiaZOKkolsrW1ocReS/yFA52ygVfbELCWmXiggh7DDnC1hCgcq1cQqAxjLGMoxFg5H3o2VMcxiy4XXFOKulROa9QZOLy9krs+Y6I7m0mGk4a7GQi2bPbizX4RqAHdkeFSImLOvxVlKXH3XnS5GSFiw/jkWVUV9uJjO3mtMJC3dCpstaAAuaNAQFailNQXbYJGwiUVokBOhiqXkcQht1IUooXZSV3F68VCAkf0AtuPEanAqaSTaQsCnFobbhqTpFlarrSu+s0pAexeOhRQcqspvvEVP6y5U/rLlT+suVP6y5U/rLlT+suVP6y5U/rLlT+suVP6y5WJFrQvZiJSsl7otmF7k7+Wp/WXKn9Zcqf1lyp/WXKn9Zcqf1lyp/WXKn9Zcqf1lypSj9d4a2Q48paSHJKUnUT4a8Fi4fhDE+XKZYZekPLlOLbbbRp0rQlCdESo2qFiswbcLk1qSzCZW1GUMtw6fLrSfJpqdJw6K1hb8ybpGkBprEwkt2Qo3UU5vGAqRiEnGHH0NBtaG0NJYSFrW4pZFgAadWy/Cly4CmpLDzr6IgzkLaSvM0pY1oC6U/iaJUKNHhxZjElD7k0LUgB5BypKQ0orpbUvDMUlsR4C1NhSAyw2sIK0GygVKJCqckwmdiOF4xOTHcZQIweL2lcGY3XmSgEIrOyMWThJkbaY0m21HLba+bSFsKOUrpzCIzuASJ7im4zL6lONvoaHlkmwsqmIGJsTcWaxPF2GEKK2MNU0lJYadzoSt3TjNe4TTWLYhCm4TIiTFx20OyIkzT54zqEAIDl2LBSQKaOASsPLkw5AVOvvxlSmkhXFkQkE+14fplz9k/uSQNOxwmtMPKp5P8Azxb+5+ll/s365Jr0PC+SmiELaQM3ECm+/wC+m/iFN/FTfxU38VN/FTfxU38VN/FTfxU38VN/FTfxU38VN/FTfxU38Qpv4qaBUbJuoazv2FN/FTfxCm/ipv4qb+Km/ipv4qb+Km/ipv4qb+Km/ipv4qb+Km/ipv4qb+Kg4oiwSk3JNcBAT7hXmoH6XK9Nxv8AtubOfa8nLmBLlszd8h3gn71/w3L0/hP7pHhz8GxNqMYplQy2S7HJzaNxDyHEqAOtJtcVicVxuJLjSZCVtLelJmOaV5bq3W12WtXKRY1Pdamx8OYddWtvPlw4BLVsqAN5IvTgfwtMkMpBGQiSkIVnBHqGqsUcwtcCRBiwi62huMzI3wkobCllI1ILhVYVi6py9pralXjILDsIr0S2kIZCBYOFJFrEGpk5WJy3ZUuRKWkurceQlCrZEoAFk6gBWIPM4hgDOCOuuLb0gisaQIy5UAZwHSKntMLxH6xXh6FthhUo76yoI0lifGKM2UmsWwebHguQwuCWLLZcWHCFB9p3jTWI4fOwyRIkR8VadSuWp2Wbvl0upWlwOnhgip8/EFYrGxGRPkLb0rzkRJS0hQSgJS0kKNkpAqcyuJMnSmV6VJUlcxrQWuU8FpFg2KekraaQgvvEFxzKLZ1kADMd82HhemXP2T+5LKtMxwHA0baRPKPF6xxjVufpZf7N+uSa9Dwvkp+xj/8A2B+2e+yeagfpcr03G/7bm/k0T2fLl0V7ptnvrv8AdtuXp/Cf3SPtXplz9k/uTVtsR9bqC4nyqbeKOP1HiO5+ll/s365Jr0PC+Sn7H6XH7Z77J5qB+lyvTcb/ALbmxnKHwnMohy3i3yAaiPXfcvT+E/ukeA6yUOhasmXx0jkKzA6j+FjU2+jcTmsze6zqV5PfRxcXrqZbM0bWZtZG+OBvL5X+1qmbzvEz5ze5HI5P+96mawyL2Z83vngec5X+1qmcN02szayxYDgbyOT/AL3qaDo205rM3ug3KvJ2uvePF6qlBIdWvJZq1lCwRwL5U744/WanX0KW89mL5gblzydsx3jxVLtpi5k/hWykW0fAvl4/XU6+gLeezGbMVX0nk7ZhveqpYTpkuZP4VsoFi3wL5TvnjqbfRLRnsze6jcL8nbMneHF6xUu2dtWWzVrIFingby99XH6qm8F0Xsze7m8eBvo5P+96mWu1xM+b3+Ry+V/tapm+7qIZ85vDgcjk/wC96m3yNJvZnfb31cDfXyv9rVKUkOrWUHRZSFCwQbIByp4uP1nwPTLn7J/cnS6XWiAyoJXYOJzWKuL734bn6WX+zfrkmvQ8L5KfsbTZbxPSrClAZUCM94xvxVcHeP2PzUD9Llem43/bc3slnc2VAKN4WzqOsfhbcvT+E/ukfavTLn7J/wChxxINswygG3quRTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR21MgORcSjy0So7gQ6EoNnEJUlQIzoJFLbYjtJbaQFJslKRYDfpz3o7ac96O2nPejtpz3o7ac96O2nPejtpz3o7ac96O2nPejtpQTDnKfcBUm5SWHGrDXv3WKc1gjhI7aUpyHBYYWUqTlKmkBJtTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbThXgeJCW3Yo/iItrZXr4CiATTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR20570dtOe9HbTnvR2058SO2nG0DfV4pA/E2P0eagfpcr03G/7bm0Dd3KVOlK+CL5U7yvx9W5en8J/dI+1emXP2T9cVebT+X2RplJNgpxYQCfVc026g7y0KCh7x4KUJuBdRsLk2HgRy9e2iDic9/ZveozDrps2246lCl+yCQTSC4gAqQCMwB3iRSHEglN0kEXG+NX0AAC5JoKSoAgg3BB+hDrauCtCgpJ/oR9k4jXmk/lXmoH6XK9Nxv8Atua8udy9mgscDjXyP+dy9P4T+6R9q9Mufsn64q82n8vsmFyU4dBmYlIaxJpTsYlwpjtXSnj1qtUPA28TmYvPkqhutxG1vRZG0G2YKXWnrizOdSAnOomtFPjz8Hw6bGC2Ggt93IuSssKbU4pC0rslRLYBqQ3KxGAGp+HMtNbXw4z5KIzbancl2XGs5C85uRc0IsFZk7blScgLzcWMcrd7AZ1rUCAmn4OJJwWJKw3C2WmNPKm4i45IZbyrQSpCGltpUBTy3Y2Py3sQ2PRm2liPCwbSPAuJy5w4tbKVAlQBvS1R5kfBo63m5MV0IXiU0MuFCmmghCUtghSQpdMsswHsSEuEtSXwxBhIW2FyWGGC4hzMkLKioA8QpzEdqJjpcfQ/HlQVPFJUtUV9hDd0+tChdFQZ2y3GcfOIGRHQlcqClycZBcddSLthprVY1DxXZtjLs2O7h7iQ5PblKcW2w2Em62mmRYhWpIAvTy52yWLKwlicQShkYOWY6pSvYTpHB6zS4T2I5Cy8st/wXcSdLoU6t8hCcoVrUupTMVGIYs+/LZXHkPphQmmmwjSllCTmdcKkqyb1PwMUVhWGRocFDbIfxB3FEJJedSUElADgQclgkgmpMJiLhM2dL2q22p1xiGltpphGkSsJK1LpLn1lgyGXm4jzTyI8zEH22WG28jI0RGcpWhayulScMiOyIrEeIY5S0xDa0akTo+ibcZcLguHAcqj9k4q8yn8q81A/S5XpuN/23MeVc1l7J5s7yOX/AMb+5en8J/dI8NKG2UKWtat5KUi5JppmDAjRpEl5aFpCEShmaFiLlahvJ36cVJiBCpEWRHdjPoQ5wV5HkpJSaBFChSoicNajOSnnWXEspTKXo27OWyqJVqsKVHjPSWo6VoZcfUXXeAgJaCjc0oqdxZjCwyuM+08mXJ8khba0hSc1tRNChroXp1yQuO++ErjvNeJHf2u5rWkC6V6reH6Zc/ZP1xV5tP5fZUnKbi4Go0nMbXNhfVSbKN1Cw1mgbG4uL1Z6fK2y+sm5LmjQyLX3gEoAtSbq4RsNdIA9QApIK+EbC5/rQQn7qQAKCf6CkhZFiqwuaFBSfUQCKGuk5gLA2F7VrpIBNzYAa/XSQpXCUAAT9k4jXmU/lXmoH6XK9Nxv+2578hfms/mlcrkf1497cvT+E/ukeGlxp1BQ4hQulSVCxBHGDURcrDcXwmc9BjtoaVNj4aSEx/xyhRyCpuEoRChM6eUlMbF57KZKXJMVu2sNZBWM4TsUl7L9jy2sIkBbTqGmriY/kCiW2zWIR1xNnuLsheZwhvBFNr0IAJsGSaxDTvbC8ZGKJWt0ZsQQ4TDS4M3DHIFYjMlf+JbEwwhYJcXLiOHbCU+txKCb1NirZ2QYK8hCGgXoLDR8opCri7NYpsnmYzszwh/HJLoQ2RCjJW3wWAgIQlJqe/gbWzbHHISAy7KSxEKE7WyMaVsFCzfKpZsmscnT4GxoRRGfjKkMh9uWs5c7bjbkV21v4vGmsXanHZJEmMYjHY0zLeHpQLsGUt9IDYF0KbyEmo8daUKbzttpSrIpZcKbjiKjc+s+H6Zc/ZP/AEFCPukAgUPgFD4BQ+AUPgFD4BQ+AUPgFBwxIjz4RlABLaCq1AZ0BVsg46HwCh8AofAKHwCh8AofAKHwCh8AofAKSoTZhYWSjggMOO3H43RW8CeAKShcyCxIUhKNSS6gLIFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFJUJc7a6yUbydEty4/G6K/sFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFD4BQ+AUPgFf2CipB3wABcVvV5qB+lyvTcb/tuarbYVezuQW0St9PLH4cW/uXp/Cf3SPtXplz9k/uXoqV8o15pP5bl6WX+zfrkmvQ8L5KfsfpcftnvsnmoH6XK9Nxv+25t65py5mis30DnBUOAfxPFq3L0/hP7pH2r0y5+yf3L0VK+Ua80n8ty9LL/Zv1yTXoeF8lP2P0uP2z32TzUD9Llem43/AG3N0gSznyOBCbaJfDB4Sb8Q47HcvT+E/ukeFqSL+6m431kpiZ9VPtNJgNw3lAhnOElzShB4d+HTYLScRLYbnMOyL4ehS1aZhBJaDgQchNP4Ut/CWcUiFx9t7SxnVZfG0fAWDxVJjrD2LNynCQUxvq0FYK//ANgm6KlN4ZGlQ4mIy1PoC40mUlslAa31paLoC1U/heCPYhicMaRbTjs5yKFtpDaRwLuJsm9OMbcmw4sloOpXtUy1htJWoalAKIBtWIRXNFKdWoaMuMNx32W0LIXcfxg8kppt4nZDjMBEVD7aA61EaCkKW4oHLkp3D5hgF1sOBDimXUuaNSTvpVlNL2RRJmD4k+yiQw0y8zJhNB1PjMBALSwbKpzF0zcUgQsSgOR2W2LT3AzeKWwFpLalg2JNxTStkxnBrCndGkAsS1KLbxRax0KW3L+xQXIl4ZFfeXYC63GkqUbDwvTLn7J/6G0HiClAUx8aaYA9tNMAe2mmAPbTTAHtppgD200wB7aaiz5aITt4anNbzSklKwgp5YBuKhxp70ZDj8dpy6WSoXDdydZSNRNMAe2mmAPbTTAHtppgD200wB7aaYA9tNMAe2mmiTqCQsEn6PSy/wBm/XJNeh4XyU0EJHGTYUwB7aaYA9tNMAe2mmAPbTTAHtppgD200wB7aaYA9tNMAe2mmAPbTTAHtppgD200wB7aaYA9tNMAe2mmAPbTTAHtprD8Rak4wGny46QYq1NLSl5eXfaCSoqpgq4znTTAHtppgD200wB7aaYA9tNMAe2mmAPbTTAHtppgD200wB7aaYA9tNMAe2mmAPbTTAHtppgD200wB7aaYA9tNNKJ3kpUCfo81A/S5XpuN/2+llJGqxWBTAHtppgD200wB7aaYA9tNMAe2mmAPbTTFvbTWGYhExCeWn5byzeAtLayXTlOsFBNME+vOmmAPbTTAHtppgD200wB7aaYA9tNMAe2mmAP/wBE0lY9aSCK9P4T+6R4eKqwdiaJrOCKfSYSHQvSgAZc+QL8YIKstYtoI7s5caLpGtE0J6VpeTwLqvpDYqJIp7SxcIbwtAUoW0DagoEi3CqRnxt6C7LyOWF4W8EeoLGpfrFYgiJLnsT5eFoWgRXpMfLkcUCkqHABKQQCRTsiPCXiJQ06QpK/rLPpgvVrHjm1TJEJcJMXTuOgyciOArPbhosLGpDQxeHBiPhLgsluCAEaMW1E5RmqWt1OIS5qGVLSWkOzGw27YZQbG16lJw99pxorCxpgHHC4SDa17msRx556A9AzYk6lwNxn/KIbQ2lCRnsMxtesZxOLhDodw2DMeQtlhxAKULOVCVOFANk5ybVKLmHYdMhMkuDgS891KFta0hxQQeIGnnMPRChRYcRarhkRUFBXqA1r1X8L0y5+yfreFBS3Eha1HWSSKFChQoUKFChQoe6hQoUKFJIP4UVEJIuT6javSy/2b9ck16HhfJTV0tMNqQDvAqKrn/ahQoUKFChQoUKFChQoUKFCh7qFChQoUKFChQoUKFChQoEVdSmRmPrNeagfpcr03G/7fQU51tIJBsbKWAaSAOIChQoUKFChQoUKFChQoUKyhxlecDeJSRY16fwr90jcI8JeLYquM++6zpsjSIzr5yJuPG8SopmS8V2Rx3UZRm0OGNSlNkJvxFpGao05GJ7F2MYQGY2g0Di1hCmxrVmRZVMnDXHMVhw20x2n4ju1461JQXm3NIh8FBzpWMtQMPg4djexyAMKDP8AFdzmK+VhwquCS54gAtlFZMOxWfiMYxnERm0sIi58paUHi64sFuzgKKCI2BMQnChaI+ikqkjMdM6882ptHJQUA66EzQ7MsXlLimMm7qoEAutJzX4t5H3TTBGJ4VElMvPtR224i5clpnOhDL7inI6Q7e66gTfq+XiiXSlsMIXkgJkJbmBJyhSb8W8mskkQoclLbzDTSRthSkXZdYWtDrSlCyOXuHplz9k/XJNeaT+X0YN9RtnF0xookqRiROG5hcpVqXnKdYTwRWByJjmBQMYgmIt3QhuXKRHLT1yTcZ7hQrAjGb2WNYBKXGU/pC5Ia0qHG8+oBIrCXMPxOFi7sdmE65tlDmGIWs6QLuMq8lYJJmLwCHjEHaandCG5MhDBaezEm4z3ChWGvY2zjUWC07FbkPRtHIjbZuW0+OtQFYXFlt7HsQxWambpwn/0HtGQ2AQbODeBoQIg2LYHPiNx1rS9GXMcSSUL94VWM4tE/wDEDiLu2pqnH4khL6UJKH0WUjODUOBhMLZxAwZZQ+4J7qkqSXM3EWl1iO3p+JyZmGydOvSsRIbsrTobVe4SNrD4qw5/DNjwweNiKZK3DPlLmttlTjRByi2fj36hZpWzWZgRTddwxHQtQcAvwzasHhnGtimJYnh7scvFyOuFws+e4JI1ppp2ZIwyO6843fKorQFA6+Mjf+j736jXpZf7N+uSa9DwvkprmzP5r3PBguLgisWlv4o8tltTYd0YbQpJASfWo1hP1JhmOw8Iksl1a5rrkgIzOMqByFIK9XrFbHg3iL2Nswy4ZF0nCFnMp233xWBoaibEoePy0SnXQtQdKwtprL7OomsNGAwcYgYbIjOrc+sVqlhF3G7HLZJc1CsLVhEnEsZgoRHU7trNhqXFhZzEpsrJUQFcCFMgrLchlm0qQhnRLLnDIC7haNVYTDnYds2w7DZTkfSliQ1MYLyEHPchP36xr61hbNXYUPDFyy5FkNbbS2GAwr/Ko1DdmzNkmPWexWQ8plqPAKTkRY3BN9Q3k1KdalbBpUpYfkFSFvonrTn176gisMnPjYzPxqTLxZ50uLQxNdbyApOu6RUTCoUCLgi5LhfcRP0mIFt3+AU2GUA5aw1cN+ViMCJKCJPiPxI6nApbpshZumykIqPi09ex1GLSn1MyHC82twoSj+FqQvVrWfFpTRkR23dGrhIzpCsp/EX3PzIrzUD9Llem43/b6PPM/MFYcZ+Lpmuh/EFLTHbbhthagcliVKvWAaLY/gsTEcUSuSt0SDIuSiI42bWAGpRrBdpObJWcEY2yXw/pJMcPIcXlNrJvrrAGp8qLjLkpUlbwYC8LfDR0djey6wliLg2BQ8TxJmY45pXjIJu3GKbAABOomsLGCx9k2H4Q4Fl0TFCehCgsWOUFGemRhy8NxSXBXon06MwUqUgPOKshwLy68lYTAmtQMGxRiRELpyx574bLSs/LqWJbE1rZIhbbrhTtBqIpb8dFzfQ6VFgmsQ2tsixfZG7AQJLqG2ocSCsM2QDYi6M1Yil1rYfsVlaXbC7pdkSbPOX9axwjSZrEHY3hq2oLrqjGD8mbosxCTqUUmsDVjDWyeHhIdSXxFKJkUyEr+9dNqwpUSThuNutohrd0unwfh3z3GRdYI9JXgsDF4a4anSylmVKbjqbezG+YBy4IrDHnWtk8DB47j5cyWlxi8VuFB30kVh0RBxnHMNxRhrSFp9eHWBWnNcgW1orzLv8AxXp/Cv3SNwadcjuFbK1ozKbWUlBKL8EkEisJVirKgqe4IiQ9eS2RdS8usrQSDTDTjUcRm1obAUlkG4bBG8jVvDVWFnGpcR15azGSXnWNTLiiu2u+YJNYUJ760RYDq4qVOZmEFxCEHKbZEoJFQGMQkZtNLbYSl5ebfusC+vjqBLmRbFiS8wlx1uxzDKpQuLHWKjJdS8t4LDYzB1xORS7/AHlDUTvkVhTT78dtzEYzcVKQ4y8VhOksmygopNYRHyuuyYEcMNiziR47jSbcKytZFQYLC5cWU4mMwhrO5FcDzWaw5KhuHplz9k/XJNeaT+X0QUTZgdEh7R3z6bymo6hn5XrqC0xN0W2EBJOcMqzoFySQEkXAqOXVYkjEiu2sy205Eve0BUWZPDL7Ls5xkBbrb6iVApJUBcHKagtMTQ2JKAknOGlZ0C5JISki4FRJCp7zL0pS0nMtxhORtdxrCkp1AiojKG8Pdw9KUIsBFeOZxr+ijrNQ1pVh7eHqBSbGK0QpDR9aUkVAZiYgkImNIb8skbwWd8ioS8Q0rTu2CjxtI1bIv2hbfqETo5Td8nImEl8f0cJN6grmREspZeKNYDAs3cbxycRNQRiKpG2DKCLL0trFf9TUUNQ4b0OOjLqRHkeUbA+6qkRokZOVllF8qE3vYX+jiV+o16WX+zfrkmvQ8L5Ka5sz+a9ziz3YwIaW6nWEk3KdVrp/A1CXiTam1JkFGvM0LIVbeKk8RqMgxVy1sEDgKm+XI/8A046iyYjWGRYMTD1tfw2BGWtYIN9YOfgmoS8SaU2tEko1hbQshVt4qTxGooESW/KYGW4Q/IvpFj8V5jeoDTcstl5IRwtEvSIH4JCtYAqK+ZstmXIKkm632E5G3CfvJGoVh4xHTqkbZLeZYdUblYveyqhPoM52bZST/MPeUX/VfHUFyLh4WIjeUp0SVm6kpKSDY1FegwsGGGx8MLNmmwl3SBaSkioD76GW2UrLdrIa4AsLDxeKoaJ5kLkbYCSFaVYIUoe0DrqApmIV6BGQ2SFqzFP4pJ5J1UEpSAEpAsABxDc/MivNQP0uV6bjf9vo88x8wUxObYWVtBwG6FEWOUggi9QHlQWUMx7t2CGmzdKLCwKRxA1G0qsSTiRXbXtxCcge9oCo6oMKNNR9XFs5FuzXEurdzXBBuKw95UFlDMa7dghps3SiwsClPEDUZRfxBqe7q4Upm2R0/wCZOUWqAl3EGnWpSgjhof8AKJ9SQvjtUV5EiEzCdCk8KOwczbZ/BB1ioyn0YYcMDik3VtM77NzyajBnC23W4LYTqYQ8gtrCfaSSDUMsvwGoDrZRdK4rN8jRB5Kb6qhNRpi2lyW7E6QsnMjMSSTlNR1S1zWpqnyDmMhlBaQ57SUmwqIBFEsMjJcIE3y4seJzlVAbjYi2G5beTMHEJNwk3JIAOsAVDj6KW1LRkSdUhlJShz2gDUUORsQdxBlYBCkSnjdx0H1q468y7/xXp/Cv3SPDxBpa2UDSwGi8+hOcZilCFIUoW4QScxG9WNnYqziOI6TaLWJ5X31MMGOtMdY2y2yDpBbWnPWyNvEIzGx44WZDzpk3bCdJnDRyuuAanKxJGyAYhixB2pLLCo+R0Rgt9xwRtDwMgQCoKrZYl2PsZj/WDkpqdpVSm58d19Dem1rdKEqzhvUqsXSgbIFLwlcuM8wBbA1tBwIeAKEF6sU0P1IhOItyYcxhBnlYN1LmuqzvAZsxaGSseVIVs/bl6VEeQYycMUhJvp7ZNHxFINbJ14q5sXkqx6Q9toafOEZNAt/xFvb5ZLdbIxg0xWBsLdlM4mAlCFPqdVkI2wtoGwWhPGaxg4nAd2TxsLedjTWUtF5pLkPxXivK2bnKVmw3jWyFmMqBhwm5MMxD+aElKlqcRIf0zpygh/Qcmp7AfxCZtVwtSiwplvKrONtAOMIVchCF+H6Zc/ZP/Q40gnUjKFAf0vS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTTpHHlSkGsqUJCUj1AV6WX+zfrkmvQ8L5KaW24E5c6bax6iDS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTS+jTTqk8YSlKT76ypQkAD1AV5qB+lyvTcb/ALfRdCxb1HVrBpy3FdCSaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaX0aaW66RlClWFh6gBXp/Cv3SN236THixWktMMo4KEIFgkbmzGZbxled11YQhN4bwFyawnrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7awjrbXbWEdba7agzHhibiy2w+hxQSIjwvZJrXlNSGXo+GxmnW1RJF0rQ2EkGyKe6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynSwtERCXFtLaBUhK72zgE2vSy0xi0dxwobU4UpFxchAJtT3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuU91ST3Ke6pJ7lPdUk9ynuqSe5T3VJPcp7qknuVIedONYc5YRX0jK3IQtRJUgAAAf/ANe//9k=)

Before React 16.3

![Alt Text](data:image/png;base64,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)

[**⬆ Back to Top**](#table-of-contents)

### **What are the lifecycle methods of React?**

Before React 16.3

- **componentWillMount:** Executed before rendering and is used for App level configuration in your root component.
- **componentDidMount:** Executed after first rendering and here all AJAX requests, DOM or state updates, and set up event listeners should occur.
- **componentWillReceiveProps:** Executed when particular prop updates to trigger state transitions.
- **shouldComponentUpdate:** Determines if the component will be updated or not. By default it returns true. If you are sure that the component doesn't need to render after state or props are updated, you can return false value. It is a great place to improve performance as it allows you to prevent a re-render if component receives new prop.
- **componentWillUpdate:** Executed before re-rendering the component when there are props & state changes confirmed by shouldComponentUpdate() which returns true.
- **componentDidUpdate:** Mostly it is used to update the DOM in response to prop or state changes.
- **componentWillUnmount:** It will be used to cancel any outgoing network requests, or remove all event listeners associated with the component.

React 16.3+

- **getDerivedStateFromProps:** Invoked right before calling render() and is invoked on _every_ render. This exists for rare use cases where you need derived state. Worth reading [if you need derived state](https://reactjs.org/blog/2018/06/07/you-probably-dont-need-derived-state.html).
- **componentDidMount:** Executed after first rendering and here all AJAX requests, DOM or state updates, and set up event listeners should occur.
- **shouldComponentUpdate:** Determines if the component will be updated or not. By default it returns true. If you are sure that the component doesn't need to render after state or props are updated, you can return false value. It is a great place to improve performance as it allows you to prevent a re-render if component receives new prop.
- **getSnapshotBeforeUpdate:** Executed right before rendered output is committed to the DOM. Any value returned by this will be passed into componentDidUpdate(). This is useful to capture information from the DOM i.e. scroll position.
- **componentDidUpdate:** Mostly it is used to update the DOM in response to prop or state changes. This will not fire if shouldComponentUpdate() returns false.
- **componentWillUnmount** It will be used to cancel any outgoing network requests, or remove all event listeners associated with the component.

[**⬆ Back to Top**](#table-of-contents)

### **What are Higher-Order Components?**

A _higher-order component_ (_HOC_) is a function that takes a component and returns a new component. Basically, it's a pattern that is derived from React's compositional nature.

We call them **pure components** because they can accept any dynamically provided child component but they won't modify or copy any behavior from their input components.

const EnhancedComponent = higherOrderComponent(WrappedComponent);

HOC can be used for many use cases:

1. Code reuse, logic and bootstrap abstraction.
2. Render hijacking.
3. State abstraction and manipulation.
4. Props manipulation.

[**⬆ Back to Top**](#table-of-contents)

### **How to create props proxy for HOC component?**

You can add/edit props passed to the component using _props proxy_ pattern like this:
```jsx
function HOC(WrappedComponent) {

return class Test extends Component {

render() {

const newProps = {

title: 'New Header',

footer: false,

showFeatureX: false,

showFeatureY: true,

};

return <WrappedComponent {...this.props} {...newProps} />;

}

};

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is context?**

_Context_ provides a way to pass data through the component tree without having to pass props down manually at every level.

For example, authenticated user, locale preference, UI theme need to be accessed in the application by many components.
```jsx
const { Provider, Consumer } = React.createContext(defaultValue);
```
[**⬆ Back to Top**](#table-of-contents)

### **What is children prop?**

_Children_ is a prop (this.props.children) that allow you to pass components as data to other components, just like any other prop you use. Component tree put between component's opening and closing tag will be passed to that component as children prop.

There are a number of methods available in the React API to work with this prop. These include React.Children.map, React.Children.forEach, React.Children.count, React.Children.only, React.Children.toArray.

A simple usage of children prop looks as below,
```jsx
const MyDiv = React.createClass({

render: function () {

return <div>{this.props.children}</div>;

},

});

ReactDOM.render(

<MyDiv>

<span>{'Hello'}</span>

<span>{'World'}</span>

</MyDiv>,

node,

);
```
[**⬆ Back to Top**](#table-of-contents)

### **How to write comments in React?**

The comments in React/JSX are similar to JavaScript Multiline comments but are wrapped in curly braces.

**Single-line comments:**
```jsx
<div>

{/\* Single-line comments(In vanilla JavaScript, the single-line comments are represented by double slash(//)) \*/}

{\`Welcome ${user}, let's play React\`}

</div>

**Multi-line comments:**

<div>

{/\* Multi-line comments for more than

one line \*/}

{\`Welcome ${user}, let's play React\`}

</div>
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of using super constructor with props argument?**

A child class constructor cannot make use of this reference until super() method has been called. The same applies for ES6 sub-classes as well. The main reason of passing props parameter to super() call is to access this.props in your child constructors.

**Passing props:**
```jsx
class MyComponent extends React.Component {

constructor(props) {

super(props);

console.log(this.props); // prints { name: 'John', age: 42 }

}

}

**Not passing props:**

class MyComponent extends React.Component {

constructor(props) {

super();

console.log(this.props); // prints undefined

// but props parameter is still available

console.log(props); // prints { name: 'John', age: 42 }

}

render() {

// no difference outside constructor

console.log(this.props); // prints { name: 'John', age: 42 }

}

}
```
The above code snippets reveals that this.props is different only within the constructor. It would be the same outside the constructor.

[**⬆ Back to Top**](#table-of-contents)

### **What is reconciliation?**

When a component's props or state change, React decides whether an actual DOM update is necessary by comparing the newly returned element with the previously rendered one. When they are not equal, React will update the DOM. This process is called _reconciliation_.

[**⬆ Back to Top**](#table-of-contents)

### **How to set state with a dynamic key name?**

If you are using ES6 or the Babel transpiler to transform your JSX code then you can accomplish this with _computed property names_.
```jsx
handleInputChange(event) {

this.setState({ \[event.target.id\]: event.target.value })

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What would be the common mistake of function being called every time the component renders?**

You need to make sure that function is not being called while passing the function as a parameter.
```jsx
render() {

// Wrong: handleClick is called instead of passed as a reference!

return <button onClick={this.handleClick()}>{'Click Me'}</button>

}

Instead, pass the function itself without parenthesis:

render() {

// Correct: handleClick is passed as a reference!

return <button onClick={this.handleClick}>{'Click Me'}</button>

}
```
[**⬆ Back to Top**](#table-of-contents)

### **Is lazy function supports named exports?**

No, currently React.lazy function supports default exports only. If you would like to import modules which are named exports, you can create an intermediate module that reexports it as the default. It also ensures that tree shaking keeps working and don’t pull unused components. Let's take a component file which exports multiple named components,

// MoreComponents.js
```jsx
export const SomeComponent = /\* ... \*/;

export const UnusedComponent = /\* ... \*/;
```
and reexport MoreComponents.js components in an intermediate file IntermediateComponent.js

// IntermediateComponent.js
```jsx
export { SomeComponent as default } from './MoreComponents.js';

Now you can import the module using lazy function as below,

import React, { lazy } from 'react';

const SomeComponent = lazy(() => import('./IntermediateComponent.js'));
```
[**⬆ Back to Top**](#table-of-contents)

### **Why React uses className over class attribute?**

class is a keyword in JavaScript, and JSX is an extension of JavaScript. That's the principal reason why React uses className instead of class. Pass a string as the className prop.
```jsx
render() {

return <span className={'menu navigation-menu'}>{'Menu'}</span>

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What are fragments?**

It's common pattern in React which is used for a component to return multiple elements. _Fragments_ let you group a list of children without adding extra nodes to the DOM.
```jsx
render() {

return (

<React.Fragment>

<ChildA />

<ChildB />

<ChildC />

</React.Fragment>

)

}
```
There is also a _shorter syntax_, but it's not supported in many tools:
```jsx
render() {

return (

<>

<ChildA />

<ChildB />

<ChildC />

</>

)

}
```
[**⬆ Back to Top**](#table-of-contents)

### **Why fragments are better than container divs?**

Below are the list of reasons,

1. Fragments are a bit faster and use less memory by not creating an extra DOM node. This only has a real benefit on very large and deep trees.
2. Some CSS mechanisms like _Flexbox_ and _CSS Grid_ have a special parent-child relationships, and adding divs in the middle makes it hard to keep the desired layout.
3. The DOM Inspector is less cluttered.

[**⬆ Back to Top**](#table-of-contents)

### **What are portals in React?**

_Portal_ is a recommended way to render children into a DOM node that exists outside the DOM hierarchy of the parent component.
```jsx
ReactDOM.createPortal(child, container);
```
The first argument is any render-able React child, such as an element, string, or fragment. The second argument is a DOM element.

[**⬆ Back to Top**](#table-of-contents)

### **What are stateless components?**

If the behaviour is independent of its state then it can be a stateless component. You can use either a function or a class for creating stateless components. But unless you need to use a lifecycle hook in your components, you should go for function components. There are a lot of benefits if you decide to use function components here; they are easy to write, understand, and test, a little faster, and you can avoid the this keyword altogether.

[**⬆ Back to Top**](#table-of-contents)

### **What are stateful components?**

If the behaviour of a component is dependent on the _state_ of the component then it can be termed as stateful component. These _stateful components_ are always _class components_ and have a state that gets initialized in the constructor.
```jsx
class App extends Component {

constructor(props) {

super(props);

this.state = { count: 0 };

}

render() {

// ...

}

}
```
### **React 16.8 Update:**

Hooks let you use state and other React features without writing classes.

_The Equivalent Functional Component_
```jsx
import React, {useState} from 'react';

const App = (props) => {

const \[count, setCount\] = useState(0);

return (

// JSX

)

}
```
[**⬆ Back to Top**](#table-of-contents)

### **How to apply validation on props in React?**

When the application is running in _development mode_, React will automatically check all props that we set on components to make sure they have _correct type_. If the type is incorrect, React will generate warning messages in the console. It's disabled in _production mode_ due to performance impact. The mandatory props are defined with isRequired.

The set of predefined prop types:

1. PropTypes.number
2. PropTypes.string
3. PropTypes.array
4. PropTypes.object
5. PropTypes.func
6. PropTypes.node
7. PropTypes.element
8. PropTypes.bool
9. PropTypes.symbol
10. PropTypes.any

We can define propTypes for User component as below:
```jsx
import React from 'react';

import PropTypes from 'prop-types';

class User extends React.Component {

static propTypes = {

name: PropTypes.string.isRequired,

age: PropTypes.number.isRequired,

};

render() {

return (

<>

<h1>{\`Welcome, ${this.props.name}\`}</h1>

<h2>{\`Age, ${this.props.age}\`}</h2>

</>

);

}

}
```
**Note:** In React v15.5 _PropTypes_ were moved from React.PropTypes to prop-types library.

[**⬆ Back to Top**](#table-of-contents)

### **What are the advantages of React?**

Below are the list of main advantages of React,

1. Increases the application's performance with _Virtual DOM_.
2. JSX makes code easy to read and write.
3. It renders both on client and server side (_SSR_).
4. Easy to integrate with frameworks (Angular, Backbone) since it is only a view library.
5. Easy to write unit and integration tests with tools such as Jest.

[**⬆ Back to Top**](#table-of-contents)

### **What are the limitations of React?**

Apart from the advantages, there are few limitations of React too,

1. React is just a view library, not a full framework.
2. There is a learning curve for beginners who are new to web development.
3. Integrating React into a traditional MVC framework requires some additional configuration.
4. The code complexity increases with inline templating and JSX.
5. Too many smaller components leading to over engineering or boilerplate.

[**⬆ Back to Top**](#table-of-contents)

### **What are error boundaries in React v16?**

_Error boundaries_ are components that catch JavaScript errors anywhere in their child component tree, log those errors, and display a fallback UI instead of the component tree that crashed.

A class component becomes an error boundary if it defines a new lifecycle method called componentDidCatch(error, info) or static getDerivedStateFromError():
```jsx
class ErrorBoundary extends React.Component {

constructor(props) {

super(props);

this.state = { hasError: false };

}

componentDidCatch(error, info) {

// You can also log the error to an error reporting service

logErrorToMyService(error, info);

}

static getDerivedStateFromError(error) {

// Update state so the next render will show the fallback UI.

return { hasError: true };

}

render() {

if (this.state.hasError) {

// You can render any custom fallback UI

return <h1>{'Something went wrong.'}</h1>;

}

return this.props.children;

}

}

After that use it as a regular component:

<ErrorBoundary>

<MyWidget />

</ErrorBoundary>
```
[**⬆ Back to Top**](#table-of-contents)

### **How error boundaries handled in React v15?**

React v15 provided very basic support for _error boundaries_ using unstable_handleError method. It has been renamed to componentDidCatch in React v16.

[**⬆ Back to Top**](#table-of-contents)

### **What are the recommended ways for static type checking?**

Normally we use _PropTypes library_ (React.PropTypes moved to a prop-types package since React v15.5) for _type checking_ in the React applications. For large code bases, it is recommended to use _static type checkers_ such as Flow or TypeScript, that perform type checking at compile time and provide auto-completion features.

[**⬆ Back to Top**](#table-of-contents)

### **What is the use of react-dom package?**

The react-dom package provides _DOM-specific methods_ that can be used at the top level of your app. Most of the components are not required to use this module. Some of the methods of this package are:

1. render()
2. hydrate()
3. unmountComponentAtNode()
4. findDOMNode()
5. createPortal()

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of render method of react-dom?**

This method is used to render a React element into the DOM in the supplied container and return a reference to the component. If the React element was previously rendered into container, it will perform an update on it and only mutate the DOM as necessary to reflect the latest changes.
```jsx
ReactDOM.render(element, container\[, callback\])
```
If the optional callback is provided, it will be executed after the component is rendered or updated.

[**⬆ Back to Top**](#table-of-contents)

### **What is ReactDOMServer?**

The ReactDOMServer object enables you to render components to static markup (typically used on node server). This object is mainly used for _server-side rendering_ (SSR). The following methods can be used in both the server and browser environments:

1. renderToString()
2. renderToStaticMarkup()

For example, you generally run a Node-based web server like Express, Hapi, or Koa, and you call renderToString to render your root component to a string, which you then send as response.

// using Express
```jsx
import { renderToString } from 'react-dom/server';

import MyPage from './MyPage';

app.get('/', (req, res) => {

res.write('<!DOCTYPE html><html><head><title>My Page</title></head><body>');

res.write('<div id="content">');

res.write(renderToString(<MyPage />));

res.write('</div></body></html>');

res.end();

});
```
[**⬆ Back to Top**](#table-of-contents)

### **How to use innerHTML in React?**

The dangerouslySetInnerHTML attribute is React's replacement for using innerHTML in the browser DOM. Just like innerHTML, it is risky to use this attribute considering cross-site scripting (XSS) attacks. You just need to pass a \__html object as key and HTML text as value.

In this example MyComponent uses dangerouslySetInnerHTML attribute for setting HTML markup:
```jsx
function createMarkup() {

return { \__html: 'First &middot; Second' };

}

function MyComponent() {

return <div dangerouslySetInnerHTML={createMarkup()} />;

}
```
[**⬆ Back to Top**](#table-of-contents)

### **How to use styles in React?**

The style attribute accepts a JavaScript object with camelCased properties rather than a CSS string. This is consistent with the DOM style JavaScript property, is more efficient, and prevents XSS security holes.
```jsx
const divStyle = {

color: 'blue',

backgroundImage: 'url(' + imgUrl + ')',

};

function HelloWorldComponent() {

return <div style={divStyle}>Hello World!</div>;

}
```
Style keys are camelCased in order to be consistent with accessing the properties on DOM nodes in JavaScript (e.g. node.style.backgroundImage).

[**⬆ Back to Top**](#table-of-contents)

### **How events are different in React?**

Handling events in React elements has some syntactic differences:

1. React event handlers are named using camelCase, rather than lowercase.
2. With JSX you pass a function as the event handler, rather than a string.

[**⬆ Back to Top**](#table-of-contents)

### **What will happen if you use setState() in constructor?**

When you use setState(), then apart from assigning to the object state React also re-renders the component and all its children. You would get error like this: _Can only update a mounted or mounting component._ So we need to use this.state to initialize variables inside constructor.

[**⬆ Back to Top**](#table-of-contents)

### **What is the impact of indexes as keys?**

Keys should be stable, predictable, and unique so that React can keep track of elements.

In the below code snippet each element's key will be based on ordering, rather than tied to the data that is being represented. This limits the optimizations that React can do.
```jsx
{

todos.map((todo, index) => <Todo {...todo} key={index} />);

}
```
If you use element data for unique key, assuming todo.id is unique to this list and stable, React would be able to reorder elements without needing to reevaluate them as much.
```jsx
{

todos.map((todo) => <Todo {...todo} key={todo.id} />);

}
```
[**⬆ Back to Top**](#table-of-contents)

### **Is it good to use setState() in componentWillMount() method?**

Yes, it is safe to use setState() inside componentWillMount() method. But at the same it is recommended to avoid async initialization in componentWillMount() lifecycle method. componentWillMount() is invoked immediately before mounting occurs. It is called before render(), therefore setting state in this method will not trigger a re-render. Avoid introducing any side-effects or subscriptions in this method. We need to make sure async calls for component initialization happened in componentDidMount() instead of componentWillMount().
```jsx
componentDidMount() {

axios.get(\`api/todos\`)

.then((result) => {

this.setState({

messages: \[...result.data\]

})

})

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What will happen if you use props in initial state?**

If the props on the component are changed without the component being refreshed, the new prop value will never be displayed because the constructor function will never update the current state of the component. The initialization of state from props only runs when the component is first created.

The below component won't display the updated input value:
```jsx
class MyComponent extends React.Component {

constructor(props) {

super(props);

this.state = {

records: \[\],

inputValue: this.props.inputValue,

};

}

render() {

return <div>{this.state.inputValue}</div>;

}

}

Using props inside render method will update the value:

class MyComponent extends React.Component {

constructor(props) {

super(props);

this.state = {

record: \[\],

};

}

render() {

return <div>{this.props.inputValue}</div>;

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **How do you conditionally render components?**

In some cases you want to render different components depending on some state. JSX does not render false or undefined, so you can use conditional _short-circuiting_ to render a given part of your component only if a certain condition is true.
```jsx
const MyComponent = ({ name, address }) => (

<div>

<h2>{name}</h2>

{address && <p>{address}</p>}

</div>

);
```
If you need an if-else condition then use _ternary operator_.
```jsx
const MyComponent = ({ name, address }) => (

<div>

<h2>{name}</h2>

{address ? <p>{address}</p> : <p>{'Address is not available'}</p>}

</div>

);
```
[**⬆ Back to Top**](#table-of-contents)

### **Why we need to be careful when spreading props on DOM elements?**

When we _spread props_ we run into the risk of adding unknown HTML attributes, which is a bad practice. Instead we can use prop destructuring with ...rest operator, so it will add only required props.

For example,
```jsx
const ComponentA = () => <ComponentB isDisplay={true} className={'componentStyle'} />;

const ComponentB = ({ isDisplay, ...domProps }) => <div {...domProps}>{'ComponentB'}</div>;
```
[**⬆ Back to Top**](#table-of-contents)

### **How you use decorators in React?**

You can _decorate_ your _class_ components, which is the same as passing the component into a function. **Decorators** are flexible and readable way of modifying component functionality.
```jsx
@setTitle('Profile')

class Profile extends React.Component {

//....

}
```
/\*

title is a string that will be set as a document title

WrappedComponent is what our decorator will receive when

put directly above a component class as seen in the example above

\*/
```jsx
const setTitle = (title) => (WrappedComponent) => {

return class extends React.Component {

componentDidMount() {

document.title = title;

}

render() {

return <WrappedComponent {...this.props} />;

}

};

};
```
**Note:** Decorators are a feature that didn't make it into ES7, but are currently a _stage 2 proposal_.

[**⬆ Back to Top**](#table-of-contents)

### **How do you memoize a component?**

There are memoize libraries available which can be used on function components.

For example moize library can memoize the component in another component.
```jsx
import moize from 'moize';

import Component from './components/Component'; // this module exports a non-memoized component

const MemoizedFoo = moize.react(Component);

const Consumer = () => {

<div>

{'I will memoize the following entry:'}

<MemoizedFoo />

</div>;

};
```
**Update:** Since React v16.6.0, we have a React.memo. It provides a higher order component which memoizes component unless the props change. To use it, simply wrap the component using React.memo before you use it.

const MemoComponent = React.memo(function MemoComponent(props) {

/\* render using props \*/

});

OR;

export default React.memo(MyFunctionComponent);

[**⬆ Back to Top**](#table-of-contents)

### **How you implement Server Side Rendering or SSR?**

React is already equipped to handle rendering on Node servers. A special version of the DOM renderer is available, which follows the same pattern as on the client side.

import ReactDOMServer from 'react-dom/server';

import App from './App';

ReactDOMServer.renderToString(<App />);

This method will output the regular HTML as a string, which can be then placed inside a page body as part of the server response. On the client side, React detects the pre-rendered content and seamlessly picks up where it left off.

[**⬆ Back to Top**](#table-of-contents)

### **How to enable production mode in React?**

You should use Webpack's DefinePlugin method to set NODE_ENV to production, by which it strip out things like propType validation and extra warnings. Apart from this, if you minify the code, for example, Uglify's dead-code elimination to strip out development only code and comments, it will drastically reduce the size of your bundle.

[**⬆ Back to Top**](#table-of-contents)

### **What is CRA and its benefits?**

The create-react-app CLI tool allows you to quickly create & run React applications with no configuration step.

Let's create Todo App using _CRA_:

\# Installation

$ npm install -g create-react-app

\# Create new project

$ create-react-app todo-app

$ cd todo-app

\# Build, test and run

$ npm run build

$ npm run test

$ npm start

It includes everything we need to build a React app:

1. React, JSX, ES6, and Flow syntax support.
2. Language extras beyond ES6 like the object spread operator.
3. Autoprefixed CSS, so you don’t need -webkit- or other prefixes.
4. A fast interactive unit test runner with built-in support for coverage reporting.
5. A live development server that warns about common mistakes.
6. A build script to bundle JS, CSS, and images for production, with hashes and sourcemaps.

[**⬆ Back to Top**](#table-of-contents)

### **What is the lifecycle methods order in mounting?**

The lifecycle methods are called in the following order when an instance of a component is being created and inserted into the DOM.

1. constructor()
2. static getDerivedStateFromProps()
3. render()
4. componentDidMount()

[**⬆ Back to Top**](#table-of-contents)

### **What are the lifecycle methods going to be deprecated in React v16?**

The following lifecycle methods going to be unsafe coding practices and will be more problematic with async rendering.

1. componentWillMount()
2. componentWillReceiveProps()
3. componentWillUpdate()

Starting with React v16.3 these methods are aliased with UNSAFE_ prefix, and the unprefixed version will be removed in React v17.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of getDerivedStateFromProps() lifecycle method?**

The new static getDerivedStateFromProps() lifecycle method is invoked after a component is instantiated as well as before it is re-rendered. It can return an object to update state, or null to indicate that the new props do not require any state updates.

class MyComponent extends React.Component {

static getDerivedStateFromProps(props, state) {

// ...

}

}

This lifecycle method along with componentDidUpdate() covers all the use cases of componentWillReceiveProps().

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of getSnapshotBeforeUpdate() lifecycle method?**

The new getSnapshotBeforeUpdate() lifecycle method is called right before DOM updates. The return value from this method will be passed as the third parameter to componentDidUpdate().

class MyComponent extends React.Component {

getSnapshotBeforeUpdate(prevProps, prevState) {

// ...

}

}

This lifecycle method along with componentDidUpdate() covers all the use cases of componentWillUpdate().

[**⬆ Back to Top**](#table-of-contents)

### **Do Hooks replace render props and higher order components?**

Both render props and higher-order components render only a single child but in most of the cases Hooks are a simpler way to serve this by reducing nesting in your tree.

[**⬆ Back to Top**](#table-of-contents)

### **What is the recommended way for naming components?**

It is recommended to name the component by reference instead of using displayName.

Using displayName for naming component:

export default React.createClass({

displayName: 'TodoApp',

// ...

});

The **recommended** approach:

export default class TodoApp extends React.Component {

// ...

}

[**⬆ Back to Top**](#table-of-contents)

### **What is the recommended ordering of methods in component class?**

_Recommended_ ordering of methods from _mounting_ to _render stage_:

1. static methods
2. constructor()
3. getChildContext()
4. componentWillMount()
5. componentDidMount()
6. componentWillReceiveProps()
7. shouldComponentUpdate()
8. componentWillUpdate()
9. componentDidUpdate()
10. componentWillUnmount()
11. click handlers or event handlers like onClickSubmit() or onChangeDescription()
12. getter methods for render like getSelectReason() or getFooterContent()
13. optional render methods like renderNavigation() or renderProfilePicture()
14. render()

[**⬆ Back to Top**](#table-of-contents)

### **What is a switching component?**

A _switching component_ is a component that renders one of many components. We need to use object to map prop values to components.

For example, a switching component to display different pages based on page prop:

import HomePage from './HomePage';

import AboutPage from './AboutPage';

import ServicesPage from './ServicesPage';

import ContactPage from './ContactPage';

const PAGES = {

home: HomePage,

about: AboutPage,

services: ServicesPage,

contact: ContactPage,

};

const Page = (props) => {

const Handler = PAGES\[props.page\] || ContactPage;

return <Handler {...props} />;

};

// The keys of the PAGES object can be used in the prop types to catch dev-time errors.

Page.propTypes = {

page: PropTypes.oneOf(Object.keys(PAGES)).isRequired,

};

[**⬆ Back to Top**](#table-of-contents)

### **Why we need to pass a function to setState()?**

The reason behind for this is that setState() is an asynchronous operation. React batches state changes for performance reasons, so the state may not change immediately after setState() is called. That means you should not rely on the current state when calling setState() since you can't be sure what that state will be. The solution is to pass a function to setState(), with the previous state as an argument. By doing this you can avoid issues with the user getting the old state value on access due to the asynchronous nature of setState().

Let's say the initial count value is zero. After three consecutive increment operations, the value is going to be incremented only by one.

// assuming this.state.count === 0

this.setState({ count: this.state.count + 1 });

this.setState({ count: this.state.count + 1 });

this.setState({ count: this.state.count + 1 });

// this.state.count === 1, not 3

If we pass a function to setState(), the count gets incremented correctly.

this.setState((prevState, props) => ({

count: prevState.count + props.increment,

}));

// this.state.count === 3 as expected

**(OR)**

### **Why function is preferred over object for setState()?**

React may batch multiple setState() calls into a single update for performance. Because this.props and this.state may be updated asynchronously, you should not rely on their values for calculating the next state.

This counter example will fail to update as expected:

// Wrong

this.setState({

counter: this.state.counter + this.props.increment,

});

The preferred approach is to call setState() with function rather than object. That function will receive the previous state as the first argument, and the props at the time the update is applied as the second argument.

// Correct

this.setState((prevState, props) => ({

counter: prevState.counter + props.increment,

}));

[**⬆ Back to Top**](#table-of-contents)

### **What is strict mode in React?**

React.StrictMode is a useful component for highlighting potential problems in an application. Just like <Fragment>, <StrictMode> does not render any extra DOM elements. It activates additional checks and warnings for its descendants. These checks apply for _development mode_ only.

import React from 'react';

function ExampleApplication() {

return (

<div>

<Header />

<React.StrictMode>

<div>

<ComponentOne />

<ComponentTwo />

</div>

</React.StrictMode>

<Footer />

</div>

);

}

In the example above, the _strict mode_ checks apply to <ComponentOne> and <ComponentTwo> components only.

[**⬆ Back to Top**](#table-of-contents)

### **What are React Mixins?**

_Mixins_ are a way to totally separate components to have a common functionality. Mixins **should not be used** and can be replaced with _higher-order components_ or _decorators_.

One of the most commonly used mixins is PureRenderMixin. You might be using it in some components to prevent unnecessary re-renders when the props and state are shallowly equal to the previous props and state:

const PureRenderMixin = require('react-addons-pure-render-mixin');

const Button = React.createClass({

mixins: \[PureRenderMixin\],

// ...

});

[**⬆ Back to Top**](#table-of-contents)

### **Why is isMounted() an anti-pattern and what is the proper solution?**

The primary use case for isMounted() is to avoid calling setState() after a component has been unmounted, because it will emit a warning.

if (this.isMounted()) {

this.setState({...})

}

Checking isMounted() before calling setState() does eliminate the warning, but it also defeats the purpose of the warning. Using isMounted() is a code smell because the only reason you would check is because you think you might be holding a reference after the component has unmounted.

An optimal solution would be to find places where setState() might be called after a component has unmounted, and fix them. Such situations most commonly occur due to callbacks, when a component is waiting for some data and gets unmounted before the data arrives. Ideally, any callbacks should be canceled in componentWillUnmount(), prior to unmounting.

[**⬆ Back to Top**](#table-of-contents)

### **What are the Pointer Events supported in React?**

_Pointer Events_ provide a unified way of handling all input events. In the old days we had a mouse and respective event listeners to handle them but nowadays we have many devices which don't correlate to having a mouse, like phones with touch surface or pens. We need to remember that these events will only work in browsers that support the _Pointer Events_ specification.

The following event types are now available in _React DOM_:

1. onPointerDown
2. onPointerMove
3. onPointerUp
4. onPointerCancel
5. onGotPointerCapture
6. onLostPointerCapture
7. onPointerEnter
8. onPointerLeave
9. onPointerOver
10. onPointerOut

[**⬆ Back to Top**](#table-of-contents)

### **Why should component names start with capital letter?**

If you are rendering your component using JSX, the name of that component has to begin with a capital letter otherwise React will throw an error as unrecognized tag. This convention is because only HTML elements and SVG tags can begin with a lowercase letter.

class SomeComponent extends Component {

// Code goes here

}

You can define component class which name starts with lowercase letter, but when it's imported it should have capital letter. Here lowercase is fine:

class myComponent extends Component {

render() {

return <div />;

}

}

export default myComponent;

While when imported in another file it should start with capital letter:

import MyComponent from './MyComponent';

### **What are the exceptions on React component naming?**

The component names should start with a uppercase letter but there are few exceptions on this convention. The lowercase tag names with a dot (property accessors) are still considered as valid component names.

For example the below tag can be compiled to a valid component,

render(){

return (

<obj.component /> // \`React.createElement(obj.component)\`

)

}

[**⬆ Back to Top**](#table-of-contents)

### **Are custom DOM attributes supported in React v16?**

Yes. In the past, React used to ignore unknown DOM attributes. If you wrote JSX with an attribute that React doesn't recognize, React would just skip it.

For example, let's take a look at the below attribute:

<div mycustomattribute={'something'} />

Would render an empty div to the DOM with React v15:

<div />

In React v16 any unknown attributes will end up in the DOM:

<div mycustomattribute="something" />

This is useful for supplying browser-specific non-standard attributes, trying new DOM APIs, and integrating with opinionated third-party libraries.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between constructor and getInitialState?**

You should initialize state in the constructor when using ES6 classes, and getInitialState() method when using React.createClass().

**Using ES6 classes:**

class MyComponent extends React.Component {

constructor(props) {

super(props);

this.state = {

/\* initial state \*/

};

}

}

**Using React.createClass():**

const MyComponent = React.createClass({

getInitialState() {

return {

/\* initial state \*/

};

},

});

**Note:** React.createClass() is deprecated and removed in React v16. Use plain JavaScript classes instead.

[**⬆ Back to Top**](#table-of-contents)

### **Can you force a component to re-render without calling setState?**

By default, when your component's state or props change, your component will re-render. If your render() method depends on some other data, you can tell React that the component needs re-rendering by calling forceUpdate().

component.forceUpdate(callback);

It is recommended to avoid all uses of forceUpdate() and only read from this.props and this.state in render().

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between super() and super(props) in React using ES6 classes?**

When you want to access this.props in constructor() then you should pass props to super() method.

**Using super(props):**

class MyComponent extends React.Component {

constructor(props) {

super(props);

console.log(this.props); // { name: 'John', ... }

}

}

**Using super():**

class MyComponent extends React.Component {

constructor(props) {

super();

console.log(this.props); // undefined

}

}

Outside constructor() both will display same value for this.props.

[**⬆ Back to Top**](#table-of-contents)

### **How to loop inside JSX?**

You can simply use Array.prototype.map with ES6 _arrow function_ syntax.

For example, the items array of objects is mapped into an array of components:

<tbody>

{items.map((item) => (

<SomeComponent key={item.id} name={item.name} />

))}

</tbody>

But you can't iterate using for loop:

<tbody>

for (let i = 0; i < items.length; i++) {

<SomeComponent key={items\[i\].id} name={items\[i\].name} />

}

</tbody>

This is because JSX tags are transpiled into _function calls_, and you can't use statements inside expressions. This may change thanks to do expressions which are _stage 1 proposal_.

[**⬆ Back to Top**](#table-of-contents)

### **How do you access props in attribute quotes?**

React (or JSX) doesn't support variable interpolation inside an attribute value. The below representation won't work:

<img className="image" src="images/{this.props.image}" />

But you can put any JS expression inside curly braces as the entire attribute value. So the below expression works:

<img className="image" src={'images/' + this.props.image} />

Using _template strings_ will also work:

<img className="image" src={\`images/${this.props.image}\`} />

[**⬆ Back to Top**](#table-of-contents)

### **What is React proptype array with shape?**

If you want to pass an array of objects to a component with a particular shape then use React.PropTypes.shape() as an argument to React.PropTypes.arrayOf().

ReactComponent.propTypes = {

arrayWithShape: React.PropTypes.arrayOf(

React.PropTypes.shape({

color: React.PropTypes.string.isRequired,

fontSize: React.PropTypes.number.isRequired,

}),

).isRequired,

};

[**⬆ Back to Top**](#table-of-contents)

### **How to conditionally apply class attributes?**

You shouldn't use curly braces inside quotes because it is going to be evaluated as a string.

<div className="btn-panel {this.props.visible ? 'show' : 'hidden'}">

Instead you need to move curly braces outside (don't forget to include spaces between class names):

<div className={'btn-panel ' + (this.props.visible ? 'show' : 'hidden')}>

_Template strings_ will also work:

<div className={\`btn-panel ${this.props.visible ? 'show' : 'hidden'}\`}>

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between React and ReactDOM?**

The react package contains React.createElement(), React.Component, React.Children, and other helpers related to elements and component classes. You can think of these as the isomorphic or universal helpers that you need to build components. The react-dom package contains ReactDOM.render(), and in react-dom/server we have _server-side rendering_ support with ReactDOMServer.renderToString() and ReactDOMServer.renderToStaticMarkup().

[**⬆ Back to Top**](#table-of-contents)

### **Why ReactDOM is separated from React?**

The React team worked on extracting all DOM-related features into a separate library called _ReactDOM_. React v0.14 is the first release in which the libraries are split. By looking at some of the packages, react-native, react-art, react-canvas, and react-three, it has become clear that the beauty and essence of React has nothing to do with browsers or the DOM.

To build more environments that React can render to, React team planned to split the main React package into two: react and react-dom. This paves the way to writing components that can be shared between the web version of React and React Native.

[**⬆ Back to Top**](#table-of-contents)

### **How to use React label element?**

If you try to render a <label> element bound to a text input using the standard for attribute, then it produces HTML missing that attribute and prints a warning to the console.

<label for={'user'}>{'User'}</label>

<input type={'text'} id={'user'} />

Since for is a reserved keyword in JavaScript, use htmlFor instead.

<label htmlFor={'user'}>{'User'}</label>

<input type={'text'} id={'user'} />

[**⬆ Back to Top**](#table-of-contents)

### **How to combine multiple inline style objects?**

You can use _spread operator_ in regular React:

<button style={{ ...styles.panel.button, ...styles.panel.submitButton }}>{'Submit'}</button>

If you're using React Native then you can use the array notation:

<button style={\[styles.panel.button, styles.panel.submitButton\]}>{'Submit'}</button>

[**⬆ Back to Top**](#table-of-contents)

### **How to re-render the view when the browser is resized?**

You can listen to the resize event in componentDidMount() and then update the dimensions (width and height). You should remove the listener in componentWillUnmount() method.

class WindowDimensions extends React.Component {

constructor(props) {

super(props);

this.updateDimensions = this.updateDimensions.bind(this);

}

componentWillMount() {

this.updateDimensions();

}

componentDidMount() {

window.addEventListener('resize', this.updateDimensions);

}

componentWillUnmount() {

window.removeEventListener('resize', this.updateDimensions);

}

updateDimensions() {

this.setState({ width: window.innerWidth, height: window.innerHeight });

}

render() {

return (

<span>

{this.state.width} x {this.state.height}

</span>

);

}

}

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between setState() and replaceState() methods?**

When you use setState() the current and previous states are merged. replaceState() throws out the current state, and replaces it with only what you provide. Usually setState() is used unless you really need to remove all previous keys for some reason. You can also set state to false/null in setState() instead of using replaceState().

[**⬆ Back to Top**](#table-of-contents)

### **How to listen to state changes?**

The componentDidUpdate lifecycle method will be called when state changes. You can compare provided state and props values with current state and props to determine if something meaningful changed.

componentDidUpdate(object prevProps, object prevState)

**Note:** The previous releases of ReactJS also uses componentWillUpdate(object nextProps, object nextState) for state changes. It has been deprecated in latest releases.

[**⬆ Back to Top**](#table-of-contents)

### **What is the recommended approach of removing an array element in React state?**

The better approach is to use Array.prototype.filter() method.

For example, let's create a removeItem() method for updating the state.

removeItem(index) {

this.setState({

data: this.state.data.filter((item, i) => i !== index)

})

}

[**⬆ Back to Top**](#table-of-contents)

### **Is it possible to use React without rendering HTML?**

It is possible with latest version (>=16.2). Below are the possible options:

render() {

return false

}

render() {

return null

}

render() {

return \[\]

}

render() {

return <React.Fragment></React.Fragment>

}

render() {

return <></>

}

Returning undefined won't work.

[**⬆ Back to Top**](#table-of-contents)

### **How to pretty print JSON with React?**

We can use `<pre>` tag so that the formatting of the JSON.stringify() is retained:

```jsx
const data = { name: 'John', age: 42 };

class User extends React.Component {

render() {

return <pre>{JSON.stringify(data, null, 2)}</pre>;

}

}

React.render(<User />, document.getElementById('container'));
```

[**⬆ Back to Top**](#table-of-contents)

### **Why you can't update props in React?**

The React philosophy is that props should be _immutable_ and _top-down_. This means that a parent can send any prop values to a child, but the child can't modify received props.

[**⬆ Back to Top**](#table-of-contents)

### **How to focus an input element on page load?**

You can do it by creating _ref_ for input element and using it in componentDidMount():
```jsx
class App extends React.Component {

componentDidMount() {

this.nameInput.focus();

}

render() {

return (

<div>

<input defaultValue={"Won't focus"} />

<input ref={(input) => (this.nameInput = input)} defaultValue={'Will focus'} />

</div>

);

}

}

ReactDOM.render(<App />, document.getElementById('app'));
```

[**⬆ Back to Top**](#table-of-contents)

### **What are the possible ways of updating objects in state?**

1. **Calling setState() with an object to merge with state:**

- Using Object.assign() to create a copy of the object:
- const user = Object.assign({}, this.state.user, { age: 42 });
- this.setState({ user });
- Using _spread operator_:
- const user = { ...this.state.user, age: 42 };
- this.setState({ user });

1. **Calling setState() with a function:**
```jsx
this.setState((prevState) => ({

user: {

...prevState.user,

age: 42,

},

}));
```
[**⬆ Back to Top**](#table-of-contents)

### **How can we find the version of React at runtime in the browser?**

You can use React.version to get the version.

const REACT_VERSION = React.version;

ReactDOM.render(<div>{\`React version: ${REACT_VERSION}\`}</div>, document.getElementById('app'));

[**⬆ Back to Top**](#table-of-contents)

### **What are the approaches to include polyfills in your create-react-app?**

There are approaches to include polyfills in create-react-app,

1. **Manual import from core-js:**

Create a file called (something like) polyfills.js and import it into root index.js file. Run npm install core-js or yarn add core-js and import your specific required features.
```jsx
import 'core-js/fn/array/find';

import 'core-js/fn/array/includes';

import 'core-js/fn/number/is-nan';
```
1. **Using Polyfill service:**

Use the polyfill.io CDN to retrieve custom, browser-specific polyfills by adding this line to index.html:

<script src="<https://cdn.polyfill.io/v2/polyfill.min.js?features=default,Array.prototype.includes"></script>>

In the above script we had to explicitly request the Array.prototype.includes feature as it is not included in the default feature set.

[**⬆ Back to Top**](#table-of-contents)

### **How to use https instead of http in create-react-app?**

You just need to use HTTPS=true configuration. You can edit your package.json scripts section:

"scripts": {

"start": "set HTTPS=true && react-scripts start"

}

or just run set HTTPS=true && npm start

[**⬆ Back to Top**](#table-of-contents)

### **How to avoid using relative path imports in create-react-app?**

Create a file called .env in the project root and write the import path:

NODE_PATH=src/app

After that restart the development server. Now you should be able to import anything inside src/app without relative paths.

[**⬆ Back to Top**](#table-of-contents)

### **How to add Google Analytics for React Router?**

Add a listener on the history object to record each page view:

history.listen(function (location) {

window.ga('set', 'page', location.pathname + location.search);

window.ga('send', 'pageview', location.pathname + location.search);

});

[**⬆ Back to Top**](#table-of-contents)

### **How to update a component every second?**

You need to use setInterval() to trigger the change, but you also need to clear the timer when the component unmounts to prevent errors and memory leaks.

componentDidMount() {

this.interval = setInterval(() => this.setState({ time: Date.now() }), 1000)

}

componentWillUnmount() {

clearInterval(this.interval)

}

[**⬆ Back to Top**](#table-of-contents)

### **How do you apply vendor prefixes to inline styles in React?**

React _does not_ apply _vendor prefixes_ automatically. You need to add vendor prefixes manually.

<div

style={{

transform: 'rotate(90deg)',

WebkitTransform: 'rotate(90deg)', // note the capital 'W' here

msTransform: 'rotate(90deg)', // 'ms' is the only lowercase vendor prefix

}}

/>

[**⬆ Back to Top**](#table-of-contents)

### **How to import and export components using React and ES6?**

You should use default for exporting the components

import React from 'react';

import User from 'user';

export default class MyProfile extends React.Component {

render() {

return <User type="customer">//...</User>;

}

}

With the export specifier, the MyProfile is going to be the member and exported to this module and the same can be imported without mentioning the name in other components.

[**⬆ Back to Top**](#table-of-contents)

### **Why is a component constructor called only once?**

React's _reconciliation_ algorithm assumes that without any information to the contrary, if a custom component appears in the same place on subsequent renders, it's the same component as before, so reuses the previous instance rather than creating a new one.

[**⬆ Back to Top**](#table-of-contents)

### **How to define constants in React?**

You can use ES7 static field to define constant.

class MyComponent extends React.Component {

static DEFAULT_PAGINATION = 10;

}

_Static fields_ are part of the _Class Fields_ stage 3 proposal.

[**⬆ Back to Top**](#table-of-contents)

### **How to programmatically trigger click event in React?**

You could use the ref prop to acquire a reference to the underlying HTMLInputElement object through a callback, store the reference as a class property, then use that reference to later trigger a click from your event handlers using the HTMLElement.click method.

This can be done in two steps:

1. Create ref in render method:

<input ref={(input) => (this.inputElement = input)} />

1. Apply click event in your event handler:

this.inputElement.click();

[**⬆ Back to Top**](#table-of-contents)

### **Is it possible to use async/await in plain React?**

If you want to use async/await in React, you will need _Babel_ and [transform-async-to-generator](https://babeljs.io/docs/en/babel-plugin-transform-async-to-generator) plugin. React Native ships with Babel and a set of transforms.

[**⬆ Back to Top**](#table-of-contents)

### **What are the common folder structures for React?**

There are two common practices for React project file structure.

1. **Grouping by features or routes:**

One common way to structure projects is locate CSS, JS, and tests together, grouped by feature or route.

common/

├─ Avatar.js

├─ Avatar.css

├─ APIUtils.js

└─ APIUtils.test.js

feed/

├─ index.js

├─ Feed.js

├─ Feed.css

├─ FeedStory.js

├─ FeedStory.test.js

└─ FeedAPI.js

profile/

├─ index.js

├─ Profile.js

├─ ProfileHeader.js

├─ ProfileHeader.css

└─ ProfileAPI.js

1. **Grouping by file type:**

Another popular way to structure projects is to group similar files together.

api/

├─ APIUtils.js

├─ APIUtils.test.js

├─ ProfileAPI.js

└─ UserAPI.js

components/

├─ Avatar.js

├─ Avatar.css

├─ Feed.js

├─ Feed.css

├─ FeedStory.js

├─ FeedStory.test.js

├─ Profile.js

├─ ProfileHeader.js

└─ ProfileHeader.css

[**⬆ Back to Top**](#table-of-contents)

### **What are the popular packages for animation?**

_React Transition Group_ and _React Motion_ are popular animation packages in React ecosystem.

[**⬆ Back to Top**](#table-of-contents)

### **What is the benefit of styles modules?**

It is recommended to avoid hard coding style values in components. Any values that are likely to be used across different UI components should be extracted into their own modules.

For example, these styles could be extracted into a separate component:

export const colors = {

white,

black,

blue,

};

export const space = \[0, 8, 16, 32, 64\];

And then imported individually in other components:

import { space, colors } from './styles';

[**⬆ Back to Top**](#table-of-contents)

### **What are the popular React-specific linters?**

ESLint is a popular JavaScript linter. There are plugins available that analyse specific code styles. One of the most common for React is an npm package called eslint-plugin-react. By default, it will check a number of best practices, with rules checking things from keys in iterators to a complete set of prop types.

Another popular plugin is eslint-plugin-jsx-a11y, which will help fix common issues with accessibility. As JSX offers slightly different syntax to regular HTML, issues with alt text and tabindex, for example, will not be picked up by regular plugins.

[**⬆ Back to Top**](#table-of-contents)

### **How to make AJAX call and in which component lifecycle methods should I make an AJAX call?**

You can use AJAX libraries such as Axios, jQuery AJAX, and the browser built-in fetch. You should fetch data in the componentDidMount() lifecycle method. This is so you can use setState() to update your component when the data is retrieved.

For example, the employees list fetched from API and set local state:

class MyComponent extends React.Component {

constructor(props) {

super(props);

this.state = {

employees: \[\],

error: null,

};

}

componentDidMount() {

fetch('<https://api.example.com/items>')

.then((res) => res.json())

.then(

(result) => {

this.setState({

employees: result.employees,

});

},

(error) => {

this.setState({ error });

},

);

}

render() {

const { error, employees } = this.state;

if (error) {

return <div>Error: {error.message}</div>;

} else {

return (

<ul>

{employees.map((employee) => (

<li key={employee.name}>

{employee.name}-{employee.experience}

</li>

))}

</ul>

);

}

}

}

[**⬆ Back to Top**](#table-of-contents)

### **What are render props?**

**Render Props** is a simple technique for sharing code between components using a prop whose value is a function. The below component uses render prop which returns a React element.

<DataProvider render={(data) => <h1>{\`Hello ${data.target}\`}</h1>} />

Libraries such as React Router and DownShift are using this pattern.

**React Router**

[**⬆ Back to Top**](#table-of-contents)

### **What is React Router?**

React Router is a powerful routing library built on top of React that helps you add new screens and flows to your application incredibly quickly, all while keeping the URL in sync with what's being displayed on the page.

[**⬆ Back to Top**](#table-of-contents)

### **How React Router is different from history library?**

React Router is a wrapper around the history library which handles interaction with the browser's window.history with its browser and hash histories. It also provides memory history which is useful for environments that don't have global history, such as mobile app development (React Native) and unit testing with Node.

[**⬆ Back to Top**](#table-of-contents)

### **What are the <Router> components of React Router v4?**

React Router v4 provides below 3 <Router> components:

1. <BrowserRouter>
2. <HashRouter>
3. <MemoryRouter>

The above components will create _browser_, _hash_, and _memory_ history instances. React Router v4 makes the properties and methods of the history instance associated with your router available through the context in the router object.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of push() and replace() methods of history?**

A history instance has two methods for navigation purpose.

1. push()
2. replace()

If you think of the history as an array of visited locations, push() will add a new location to the array and replace() will replace the current location in the array with the new one.

[**⬆ Back to Top**](#table-of-contents)

### **How do you programmatically navigate using React Router v4?**

There are three different ways to achieve programmatic routing/navigation within components.

1. **Using the withRouter() higher-order function:**

The withRouter() higher-order function will inject the history object as a prop of the component. This object provides push() and replace() methods to avoid the usage of context.

import { withRouter } from 'react-router-dom'; // this also works with 'react-router-native'

const Button = withRouter(({ history }) => (

<button

type="button"

onClick={() => {

history.push('/new-location');

}}

\>

{'Click Me!'}

</button>

));

1. **Using <Route> component and render props pattern:**

The <Route> component passes the same props as withRouter(), so you will be able to access the history methods through the history prop.

import { Route } from 'react-router-dom';

const Button = () => (

<Route

render={({ history }) => (

<button

type="button"

onClick={() => {

history.push('/new-location');

}}

\>

{'Click Me!'}

</button>

)}

/>

);

1. **Using context:**

This option is not recommended and treated as unstable API.

const Button = (props, context) => (

<button

type="button"

onClick={() => {

context.history.push('/new-location');

}}

\>

{'Click Me!'}

</button>

);

Button.contextTypes = {

history: React.PropTypes.shape({

push: React.PropTypes.func.isRequired,

}),

};

[**⬆ Back to Top**](#table-of-contents)

### **How to get query parameters in React Router v4?**

The ability to parse query strings was taken out of React Router v4 because there have been user requests over the years to support different implementation. So the decision has been given to users to choose the implementation they like. The recommended approach is to use query strings library.

const queryString = require('query-string');

const parsed = queryString.parse(props.location.search);

You can also use URLSearchParams if you want something native:

const params = new URLSearchParams(props.location.search);

const foo = params.get('name');

You should use a _polyfill_ for IE11.

[**⬆ Back to Top**](#table-of-contents)

### **Why you get "Router may have only one child element" warning?**

You have to wrap your Route's in a <Switch> block because <Switch> is unique in that it renders a route exclusively.

At first you need to add Switch to your imports:

import { Switch, Router, Route } from 'react-router';

Then define the routes within <Switch> block:

<Router>

<Switch>

<Route {/\* ... \*/} />

<Route {/\* ... \*/} />

</Switch>

</Router>

[**⬆ Back to Top**](#table-of-contents)

### **How to pass params to history.push method in React Router v4?**

While navigating you can pass props to the history object:

this.props.history.push({

pathname: '/template',

search: '?name=sudheer',

state: { detail: response.data },

});

The search property is used to pass query params in push() method.

[**⬆ Back to Top**](#table-of-contents)

### **How to implement _default_ or _NotFound_ page?**

A <Switch> renders the first child <Route> that matches. A <Route> with no path always matches. So you just need to simply drop path attribute as below

<Switch>

<Route exact path="/" component={Home} />

<Route path="/user" component={User} />

<Route component={NotFound} />

</Switch>

[**⬆ Back to Top**](#table-of-contents)

### **How to get history on React Router v4?**

Below are the list of steps to get history object on React Router v4,

1. Create a module that exports a history object and import this module across the project.

For example, create history.js file:

import { createBrowserHistory } from 'history';

export default createBrowserHistory({

/\* pass a configuration object here if needed \*/

});

1. You should use the <Router> component instead of built-in routers. Imported the above history.js inside index.js file:

import { Router } from 'react-router-dom';

import history from './history';

import App from './App';

ReactDOM.render(

<Router history={history}>

<App />

</Router>,

holder,

);

1. You can also use push method of history object similar to built-in history object:

// some-other-file.js

import history from './history';

history.push('/go-here');

[**⬆ Back to Top**](#table-of-contents)

### **How to perform automatic redirect after login?**

The react-router package provides <Redirect> component in React Router. Rendering a <Redirect> will navigate to a new location. Like server-side redirects, the new location will override the current location in the history stack.

import React, { Component } from 'react';

import { Redirect } from 'react-router';

export default class LoginComponent extends Component {

render() {

if (this.state.isLoggedIn === true) {

return <Redirect to="/your/redirect/page" />;

} else {

return <div>{'Login Please'}</div>;

}

}

}

**React Internationalization**

[**⬆ Back to Top**](#table-of-contents)

### **What is React Intl?**

The _React Intl_ library makes internalization in React straightforward, with off-the-shelf components and an API that can handle everything from formatting strings, dates, and numbers, to pluralization. React Intl is part of _FormatJS_ which provides bindings to React via its components and API.

[**⬆ Back to Top**](#table-of-contents)

### **What are the main features of React Intl?**

Below are the main features of React Intl,

1. Display numbers with separators.
2. Display dates and times correctly.
3. Display dates relative to "now".
4. Pluralize labels in strings.
5. Support for 150+ languages.
6. Runs in the browser and Node.
7. Built on standards.

[**⬆ Back to Top**](#table-of-contents)

### **What are the two ways of formatting in React Intl?**

The library provides two ways to format strings, numbers, and dates:

1. **Using react components:**

<FormattedMessage id={'account'} defaultMessage={'The amount is less than minimum balance.'} />

1. **Using an API:**

const messages = defineMessages({

accountMessage: {

id: 'account',

defaultMessage: 'The amount is less than minimum balance.',

},

});

formatMessage(messages.accountMessage);

[**⬆ Back to Top**](#table-of-contents)

### **How to use <FormattedMessage> as placeholder using React Intl?**

The <Formatted... /> components from react-intl return elements, not plain text, so they can't be used for placeholders, alt text, etc. In that case, you should use lower level API formatMessage(). You can inject the intl object into your component using injectIntl() higher-order component and then format the message using formatMessage() available on that object.

import React from 'react';

import { injectIntl, intlShape } from 'react-intl';

const MyComponent = ({ intl }) => {

const placeholder = intl.formatMessage({ id: 'messageId' });

return <input placeholder={placeholder} />;

};

MyComponent.propTypes = {

intl: intlShape.isRequired,

};

export default injectIntl(MyComponent);

[**⬆ Back to Top**](#table-of-contents)

### **How to access current locale with React Intl?**

You can get the current locale in any component of your application using injectIntl():

import { injectIntl, intlShape } from 'react-intl';

const MyComponent = ({ intl }) => <div>{\`The current locale is ${intl.locale}\`}</div>;

MyComponent.propTypes = {

intl: intlShape.isRequired,

};

export default injectIntl(MyComponent);

[**⬆ Back to Top**](#table-of-contents)

### **How to format date using React Intl?**

The injectIntl() higher-order component will give you access to the formatDate() method via the props in your component. The method is used internally by instances of FormattedDate and it returns the string representation of the formatted date.

import { injectIntl, intlShape } from 'react-intl';

const stringDate = this.props.intl.formatDate(date, {

year: 'numeric',

month: 'numeric',

day: 'numeric',

});

const MyComponent = ({ intl }) => <div>{\`The formatted date is ${stringDate}\`}</div>;

MyComponent.propTypes = {

intl: intlShape.isRequired,

};

export default injectIntl(MyComponent);

**React Testing**

[**⬆ Back to Top**](#table-of-contents)

### **What is Shallow Renderer in React testing?**

_Shallow rendering_ is useful for writing unit test cases in React. It lets you render a component _one level deep_ and assert facts about what its render method returns, without worrying about the behavior of child components, which are not instantiated or rendered.

For example, if you have the following component:

function MyComponent() {

return (

<div>

<span className={'heading'}>{'Title'}</span>

<span className={'description'}>{'Description'}</span>

</div>

);

}

Then you can assert as follows:

import ShallowRenderer from 'react-test-renderer/shallow';

// in your test

const renderer = new ShallowRenderer();

renderer.render(<MyComponent />);

const result = renderer.getRenderOutput();

expect(result.type).toBe('div');

expect(result.props.children).toEqual(\[

<span className={'heading'}>{'Title'}</span>,

<span className={'description'}>{'Description'}</span>,

\]);

[**⬆ Back to Top**](#table-of-contents)

### **What is TestRenderer package in React?**

This package provides a renderer that can be used to render components to pure JavaScript objects, without depending on the DOM or a native mobile environment. This package makes it easy to grab a snapshot of the platform view hierarchy (similar to a DOM tree) rendered by a ReactDOM or React Native without using a browser or jsdom.

import TestRenderer from 'react-test-renderer';

const Link = ({ page, children }) => <a href={page}>{children}</a>;

const testRenderer = TestRenderer.create(

<Link page={'<https://www.facebook.com/'}>{'Facebook'}</Link>>,

);

console.log(testRenderer.toJSON());

// {

// type: 'a',

// props: { href: '<https://www.facebook.com/>' },

// children: \[ 'Facebook' \]

// }

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of ReactTestUtils package?**

_ReactTestUtils_ are provided in the with-addons package and allow you to perform actions against a simulated DOM for the purpose of unit testing.

[**⬆ Back to Top**](#table-of-contents)

**What is Jest?**

_Jest_ is a JavaScript unit testing framework created by Facebook based on Jasmine and provides automated mock creation and a jsdom environment. It's often used for testing components.

[**⬆ Back to Top**](#table-of-contents)

### **What are the advantages of Jest over Jasmine?**

There are couple of advantages compared to Jasmine:

- Automatically finds tests to execute in your source code.
- Automatically mocks dependencies when running your tests.
- Allows you to test asynchronous code synchronously.
- Runs your tests with a fake DOM implementation (via jsdom) so that your tests can be run on the command line.
- Runs tests in parallel processes so that they finish sooner.

[**⬆ Back to Top**](#table-of-contents)

### **Give a simple example of Jest test case**

Let's write a test for a function that adds two numbers in sum.js file:

const sum = (a, b) => a + b;

export default sum;

Create a file named sum.test.js which contains actual test:

import sum from './sum';

test('adds 1 + 2 to equal 3', () => {

expect(sum(1, 2)).toBe(3);

});

And then add the following section to your package.json:

{

"scripts": {

"test": "jest"

}

}

Finally, run yarn test or npm test and Jest will print a result:

$ yarn test

PASS ./sum.test.js

✓ adds 1 + 2 to equal 3 (2ms)

**React Redux**

[**⬆ Back to Top**](#table-of-contents)

### **What is flux?**

_Flux_ is an _application design paradigm_ used as a replacement for the more traditional MVC pattern. It is not a framework or a library but a new kind of architecture that complements React and the concept of Unidirectional Data Flow. Facebook uses this pattern internally when working with React.

The workflow between dispatcher, stores and views components with distinct inputs and outputs as follows:

![flux](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAA3AAAAEKCAMAAABkEkdrAAAAh1BMVEV2tshLSkxNTE5HRkhEQkL///9OTU9PTlBfr2ouRVGxsbKTk5P6+/v/5Tvy9vfM5Ou7vr+32eKgoKC4qEPs7e3r1D2YyNZmYU3g7e2ZjkZ6e3zJ2sxiY2RXVlbd4t9sbnCu1rOHv8+VoKaGiYtqtXTTvz9MYGqAeEp9voakl0U7UFyUypzs4Z4rtoBnAAAYKElEQVR42uzdC1ebShSG4VwEbJgOISKlEEDEW9X///vO7CHRnl6shoRJ5P3WOstbciwMD3s2icwkIIQMlgm7gBDAEQI4QgjgCAEcIQRwhACOEMARQgBHCOAIIYAjBHCEAI4QAjhCAEcIARwhgCOEAI4QwBECOEII4AgBHCEEcIQAjhDAEUIAR3aM7zLsfsCNj9vMZDpwzK+EHOBGya3MV4uhswrrwKhDHOBG5i2oF5lW3uBRugrXHTnGAXCj8VauEs9VVJUjDnCj8rZeKs9hklWAOMCNB1zZedNRPHSizP5mFdoax1gAbgzegoUc9TpuJg6SRvLLkxxxgBsJuFmuzSGfpRNHieXXFyXgADcKb0G5lPrmzJsRJzWunSMOcGOYUM5qU2GUQ2+TSSQlbgY4wI0C3EomlC69TVJT4pJ6PgUc4D4/uGlhwMVOwTWZmdPaOSUDArhPD64y4JzOKO2cUoWAA9wowMl7TBrn4LwV4AA3GnAp4ABHRlPhYsABjgpHhQMcoYcDHKHCAQ5whB4OcIQKR4UDHBUOcIAjVDjAESocPRzgCBUOcIQKBzjAESoc4Ag9HOAAR4WjwgGO7BNcRg8HODIsOCoc4Mh4wNHDAQ5wVDjAEXo4wBEqHOAAR+jhAEcAR4UD3KjBVXvp4Zq4x3JXgAPcaMD577zzcpOmafPmEjgZ4ABH3lXh3gEu1lpHb7ZhGT0c4Mi+Kpy0evr3Epdm3VKOTRylVDjAkT31cKn29J9W2Yn3ccUFcICjwv0KS8f6ddaYpnGcmmc1xkoszZ20eK8/aTafpub7cdoADnBHlPuL++Pv4Qw2g2uzMnFj1+U2BNNMmQ/afNtUwKhr9cwPlJ1mNuY59gFZQw8HuOPJxdfLC4d51u8Al8p0Mt3MKaWs6SzTprbJ8txK6VhWMY26WqUzrewaxsag+ZH5wovesT7c8w+H++D28hZwY0l58dVtkneAi6TPk5LVbK5Ipo2ZLJr/Mk/ZKWUHLpWiZgqgrWrm4SoyM8x/lziZUj5fXrrcCYAbT358vf3uMM/q3+CazLZvka1ck6z7sLGims3rcNHLA8wjzCyz6Xq+JtvORN8Et7h3uA8uADcqcBfH3sMZTqacNfLB9mZ68iu4rsJlm2IWm7q3BTf5NzjnPdw94AA3ELjZe8BJk6VNPC9p7CsEL6Uv2rw4Z8Ft55wi6CPgIsABjgr304xSro10Uen/K1y2ARf/WuE+OqUEHOCocK9TviiWRF7HSsW/gkv/2sNR4QAHuI9VuGz7XhQpbo3407G9Smmt/P8qpU4buTC5uWRJDwc4wH20wqWvbzGJ5LFmkmhbOrmCEttP05fX4ZRnX3qTskeFAxzgdqlwsdbxiz35k4HNO03k/SSNvJVEXhTfPKZ7p0nU2OZNW3CRfs/rcIADHBVu+6dwL2Aak+5b8ebP45ruvZPbH/z85sl0+9hmAjjAAS74yN/Dfep7mgAOcEdU4T7/PU0AB7gxVTjAAY4KBzjAAY4eDnCECkeFAxzg6OEAR6hwgAMcFY4eDnCAo8IBjlDhAAc4wFHhAEeocPRwgAMcFQ5wgKOHAxzgqHCAAxzg6OEARwBHhQMc4AAHOAI4wAEOcPRwgAMcFQ5wBHCAAxzgdgA3K44CnAoBB7hRVLil9+81gQ8buXW6bgEHuFGAaw043bgEJyuFJ2vAAW4UU8o68X5afspFTIHzlvP51Acc4D4/uGDRrbPobEIpLwqofD4FHOA+PTiZU0qJ++eKUgd8EU6W3ykCmVECDnCfHVzgz6ahXXwqSh00ck0q80mvqp0WOMABbsgSVy7sGt46i4ZOlnW/uZ07LXCAA9yg4oKVrXGuUuWOvQEOcINeN5kGbeWMmyrquZ1QAg5wYwBnxU3LsMi0GhxbUi3zqdQ3pwUOcIAbXNw8qPNw6LT5WrjJfNKlN8ABbmBxQs4c+i4yde8NcIBzQ85FZDbp2BvgAOdAnDHnIL57boADnCtyTuJ+2wEHOAI4wAEOcIADHAEcARzgAAc4AjjAsRMABzjAAQ5wgCOAI4ADHOBOQtvt7eXXy9vbH+wKwAFuiKHu8p1dATjAHT7fbq2322/sCsAB7vCZfafAAQ5wg8UPpMTdluwJwAFusBJHgQMc4AZKeUsHB7hhwfn+qf/1Y49/wOz75ffA+Sb4Jz8GfYbAgDvGv6GdHNDbbDYb/mYa+7qdht9rC4IfZY9N2Mt4+46GYG8b0HMLDDj3R9FQ4OyOKutwtRg2q7AOuhtG+XvYAn/d7rwBy503oV1vbsLTfwOmZT70CPw8Bm6HYPn87HgIhgMnB/x6VQ1/E1JP6Wq19nsPt2xA2RaJcrEFyTIP+p407LPrReJgCOROsG1pb7vcdwzKfJloR0NQHojc5DDeSof32a7CoKc4ObfWhXK2Bcmi7HmfcLMB5SpxeKvzfNp7DIL10t3yCGqxPsyt2ieH8DYrFy5XktBmZ/UabfNUhycMe8D2G26ZYSyVyy1IurNen3Ne7nYIqnp6iNVIDgKuXHibtZLigZN10Jdln31lzhht0h33i9XQWXSHWS9x5nll0VX75fXQWRSb5ar6HK9mCPJuCLLiaugU3YJbIm7/NW5yAG/BSv7BKnawGmDTxNpOCIJeo21PrmZeVE7PBs58tpmNL/3dt8A8zy4PV4V3j18Gz2Nti2uS91iP0fdrOwTV083N+eC5ebLkivIAK0oeANys1i7Xu02Tl/PrzhW6sBPTwbVt0v363SuEVGgZguLui6Nc6+543fWUYbbArlJeONDWkbMThNUBlribHGBCuXS7onsqo10FfQ5Xc35Tq9mZq6yrXtPizRBUzrx9ebyWPdjOpzuDsydtZ96MOBmCar3/EncAcDL5VvHEXdJeo22eJae3YnrmLrk53FQ937FIm/7HPF/nXxxmaXfhjqcMmRKb52fuvJ2fP8hRHM53nicNBU46ONlXjUNwk0gKRLDzaNeJHK4OvZ1Ni+2EZrcSLUNQPLoEJ+STXQuE76/NDlBX5y4jQ7Cc7X1OuX9w0oE4LXBdidt5OtA1QEXpEtxZKKO9Ywfh+9brtUtvX+4KaUPn0x7nvOTBKbgHOYiC+fT4wclFC6cFbtLI6bXedbRncpF1OXUKrpYOYr7bFhhw0oDUTsHJnHLnGVk3J3Y6ozRdnDkKdHn84IJSrqhO3CYzo53vPNoyIVs49Xa2luvqu4OTc96dW3CLPpPiWS4nnHO3keP4BMD5cqwo9+C8EYObAW484GaAAxzgAAc4wAEOcIADHOAABzjAAe5D4BTgAAc4wAEOcH8EN2dK6RKcAhzgqHCAAxzgqHCAO3FwigoHOMABDnCAAxzgAAe4cYPzAQc4wAEOcIADHOAABzjAAQ5wgAPckYLTJw9uecrgAsAB7oTAhade4T4HuAxwIwJHhaPCAQ5wVDjAAQ5wVLjTB9fEsVNwf7sR7CxfrXtAysM14A5a4W6unm4A9ydRaZq+bSY9BnDz2ma9vfV5q71qd3ALT+XHBe4uD8O8fjzdCnfz8PDw06ey0NQV4P604obWb6wh1xgz8TGAK6tEUhWLjlyrvOzzgHu8rmSpoaS4fjw+cO8rVE+JLrafal0A7q1V3KI/OIy6b6ZRdBRTyvJlqexkFcjXq+U7F9ZZL5bhkYN7XChPZYksxWAeXi+X+emBu9Evy34Unno6fyiuHgD3e2JPaU//vuiH3kcDuD9wcwMuCdtQlt5WK3sl5b2XU+rEWx45uLvES9q6zq+rwnzVel57euCE2dV2STd9w0WTv04Zs/h1WSvT0MWprAluCp+2nzRp3Lz+5LXrky8PA+7+218qXBXI2tuhOTgNllmd57a1a8M2X0/lOkhbrvMw72acZZ2b78vnQWvArbver5RH10EHbmq+qDu1c/PEtvbP7P+29s0XZQ9w3+7LD4IzxBZdqTOPvrv2vOu7blXwO/l3df8Hs72PddvKF49m4/K7A4J7GYKPgHtSm4eaTwpp5J4euobu6cp+Jo3dbx9GBy5VXtyo7ZyyiWSCqbImlqU/tc6aSaTsmlfNf+ydDXeiOhPHFxDoQjZSGi3lJVGx1rXf//s9MxN82d72PAIKtc7cc7ZWtJch+eU/Mwlkin5Lgu8RvkMfeLwKcK+vL9WnCofAwSsIvwrQLY26FaaK9nyPJ04iZASJkCjMZBLUBb0Pr8MIt3XMFO4UnhfonkoqBC6mAzES56WYQSnMDo30k1T6ou4OXPA2e3prDVyyO+zohpFllsUAVo3nJQsMMHdKFCtFYG4ihcXD89K9LsAFT7O/z62BW2tfIFhriigfFsJ/p2Il7fW+WD8spHzHo/TjQctse4/ATUHI7D9NPiczKaTFSwgEjqqUS+iDcASamaJQOCTlGRuIdwJu9ufP7OX5C4VDCDJfVZOcAsVUCF1oBXy4uBGa0riBYDWpCl9qfF1UFVUjpEw8LGwKrbUsQgDOl1Lhh1EsI/orQgCUBg6Ac8r0ULg38ODprWoXUooib0RN2hNeASwQRms4fwXE7WAsEXBu9e+dBueKDAaFqyncEzTB3+f9tMC54eHClkm2khiF394tfVpnGG1a4cMthIs1ZnzZPSocgJRZyWr4mM6XEET+moOCZTRfMKVdHeHfRziQkao9otTN59mnxZb/Avfc0qC7/vkDKveFwk086HCmAa7wtfFCE1cInIhMmRe4/tJLo7yschhyjZNDt03q2kwq+DUtq7KuPQROxwZU0o9pJ28QvbLwVWl3YIzzf0JKt6UDL+gBqFyLoskKIdNJDcjtcvBkhbEjqK3Odxs4VuwQOF+ucngbfgdxg8xUnw1c2yZ4xSYA5Nop3NbGlO+WOwvcQggQty0kLmtALaN4E4srW6Lv/oCzqFnsfi1P9gSHt6aNBILC4QeWNgCdLhG4x+aXM4CLX2ez2Z82/1l7fftC4YAymR+AU3VFeRgAJ1GWSvhcNXHwPQc6W048UZUS4zb3WDSp7VuRN0l8ZRzHSYVvEDhtjgUZAu5l1smD2dPz+dMCscZoVxb46VXzJTx9PAYAGgROkqRttF9sdjt4V23OBC56bXf++yaY/W0D3MND5ksIEzX92wAHkG3Xa9A5eI8OQItJiDjt0fsDbgph4XK5zCg6nJ9I1ilwS8r09iUWBE60AK5+ReJa2KfAnSicc6JwKSZtUQ58hA1woH8Z/qzqFCuaNU2RU0aWHjKzQ5US+hMAp3yZRFFSIJ4AXPKxSvnSzQNQiDYT3zWeLmoZMEJfQqQoyARJqxE4opGkLYmSRLcDrosHry/tgFtg5LhtgkVCag3xcAEGHWGLh9/Xyl/AiIEEru8QOErawARp1uPJHPd8DxytNJn7B+BkW4XLw+q5amEUz8xeIQf6KodTxxwuTLF+IJPqoHAoembipkpSQlfTFDmBlqAwfgJcBamdyjQahZTRR+CcVh48VzakxLJDq6Vdu02tSMUa4DYQLxNw4MCKgKPf4JxlRqdb7M4NKVs68PzURPVBqxzOZm8LYSe8CbgtJtZKZUoBthBGLra+WC9A6RC6OwTu0T8YKNepws0vpnC2aBKcf+IzVLdqXzRxP6tSAmp5M7tW1gnW7g7AgcLpEsJDEeVVugcubyCLPwPOA8koS+pr3qfAYdHEPdeDwA3eZrbk0H4tJU4I/P4NISSitCs+Khz9hnXUDVnLKuX5DmDRBEvFgQvheAuFwwrJtrARZaNw8HWcAACjMqaGQQQpXKjzl6H8JOAglJw+olFMOT/J4eZf5nC/2ipc+2mBt5NpAffDPFyVSpSwZjrbo6kzIMbbA2egY4YlDKAVBpEIXOxbhYOErQibGfN/QsqCapX2QP4FcK2qlK+2qN6iaNIsooTsLSbg9jlcbUNLaY7AQQ6nN1ee+H4i3Brgzlc4nAooZKNdxxzOwkhvSYmgQYgi5PYOgQNkskPxZEp8ZLZKiYjJf6uU0zlVKee/Oilcm3ljOxb/V+FUGqc01YaTZ1bh6rh0PACuoCplXIVYpawx6oTwsEqwr6HCJaUpJ0ChiMy+SnkCHK6DzsOwrGPnS4VrMw/33Ewbnx9S5rJY5casoCcaYmS1MbZKWW+wSpnsjsDhZEFidrvNKr8acM/VfuK7lcJhsV80603W+yolSNx6vV280xpLn+Rv4bf5q7cCnPn/wB2TtiWt5GpSOgF5Gi5athPfBNzSHgFB/HV1hTsu7ZL/KhxORGH1vMa8zgKnhcL5NogVcR6O5t5E4uE8nI/zczTPBjxCHhFNvFjSTJ2dhzsBLrTzXXCgugRwHZZ2AVNCKkhHxcpOg8tM1YSW1Bl0WfP7BLidFuS1iAZY2tVO4R6w7tOsqDzMw2HKqQTK3jazoOHUwOLh/oBbZvKwiHJKtwzMM+rS02WzqBkOT+1n5qcrTaQk4KQcEjjV3C2Q2ikyo1Uy8RL8P/g6dQg4PHcVh3QUTjYyNIHgxbjWAaNJWrjhqwiAUxRF5kqluPorPRwwiOaFgDtf4QzdLIArZih5S/Dar2iygEpCVLNUar8YZRPZ5TWrYYBroXB4n8D+noFmYYldaeKrBf6VQsgFrUkR4v0Ogfu1XC6PL+fL07WUtIgSV0vCgSb+hCPL/deWH75+PeCC/f1wJVkV7m9ApeWRTpnXcV56dh6urmNT2im0Ksc1k1WOyylx0WRN7+NayryEP1GVJf7hoFlj6ZWmrnN8yykPd9wNej/cxhxXTUJKVzdrJTembhag/N5sNsd6Zl7Dh3ffT+HWxyWS6+bVevsOtn9NP09unbsv4L77IxZOgdtz99W6/v083Dd6xEL4A+74bqlw9/yIhZ8J3Jfmfj/ggp8BXMbA3QlwdRvgWOFY4Ri4CwAXnq9wihWOFY6BGwg4J0/jihWOFY6BGwa47/hcygpvcWWFY+AYuEGAc38GcKxwDBwrHCscA8fAscIxcAwcKxwrHAPHCsfAMXDfEbiCFY5DSgaOFY4VjoFjhWOFY+AYOC6aMHAMHCscA8fAMXCscAwcA8cKx8AxcAwcA8fAMXCXDykrBo6BY+CGUzgGjoFj4Bg4Bo6B+3Ctyu8BnMh7tfYtA/cTVpqobwGcuAXgKtyidDkqb/i8ZmV6tbYeF7gcHzPreW43hXPxGahmVN52uDFs3LkJjDo8SXksW+MOjjcAXFDpc3bhvqrNcXexsnNrl9jaZlTgUiAm6RxSOgVuSDkqcBt81HjdvQnwCdbvowL3jmNeeAPAhZF/shvOKAKHKVzkON2uFXwJ+2s6Jm8uPisf9KErcGmzxeJ4hhu8qdLr2gS4H0qLbQCuIXAFdaIbAC7AFEg+jixwNoXr1tou9lc1ZkyJZRtpOnoAwFET1GNGlEUPicZOhDsYyTFjyi1mRnXHMW9Q4NwQRycxH4833JKi8HoAV9IuHOMRh1uC+EnYNSCDPBqbIBsvi9tFfcc8rPv4ejzi1hl1ga4eDAccXixDG97Mx+RN5t3HJhgyUuwvo819YwLTx4PAJYmj3aZGKlHKPiMGeZDSRj1jEbdFhYagvrMHgwJHD+ennRSHT9/mU9o8Kna6XyoIySq63iouh1/gFZYpbQqVdpZobAInpUEvMsMncrtNrWkvr7LHmNeItK8W2+EnB9bbBXZgkTiXF7jLA0f9NbJ7pmXTgS2jfeYg2Q36BN/gAQV1uLliMrQVtPOcn1Q9PADgbH8VangHEtpyDhW6hzyAB6VtgkwXQ5tW5EFRXkHgrgKc6wQ0So9lKg17JbvogSlGdADDWa/H6IoOVBTWjWY67+MAeVAmYswmKHo1wYDA0cUKcz3aldI5hAK9LhU194gdFkeMXo1NxMVqxAGj7NlbyYN0vCaQKfLmXJy3awBHF8up8kTLoYcooXSSB15P3rAs7TpuGTWxxaAeSFXYtu7XXakJ0kLJ4T2ANjCO5S3o14moCYaHTiqd4oBxDd6uApwlzg1xW95hrc5Lp7lSQT8H0AMYNIZ2AFwwgFvfEaNxwMOtjuPh22DvwK16cGyCGwFu32E96P0DG0aTF7hSewfGMOcSHsD3A+emPaB69yh9iM7fcd0r4HYt4Ki9XWccu8zAFNj2Hs2D4KYduEgb3HwTDAicRQ6u1+AWXOxKjeTA5TwIxvTg9jvRVXi7HnDN1RrD2ANugm/kwmDAsbGxMXBsbAwcGxsDx8bGxsCxsTFwbGxsDBwbGwPHxsbAsbGxMXBsbAwcGxsbA8fGxsCxsbH9r306IAEAAAAQ9P91OwL9oHAgHAgHCAfCAcKBcCAcIBwIBwgHwgHCgXAgHCAcCAcIB8KBcIBwsBe1YXBYBcIfgAAAAABJRU5ErkJggg==)

[**⬆ Back to Top**](#table-of-contents)

### **What is Redux?**

_Redux_ is a predictable state container for JavaScript apps based on the _Flux design pattern_. Redux can be used together with React, or with any other view library. It is tiny (about 2kB) and has no dependencies.

[**⬆ Back to Top**](#table-of-contents)

### **What are the core principles of Redux?**

Redux follows three fundamental principles:

1. **Single source of truth:** The state of your whole application is stored in an object tree within a single store. The single state tree makes it easier to keep track of changes over time and debug or inspect the application.
2. **State is read-only:** The only way to change the state is to emit an action, an object describing what happened. This ensures that neither the views nor the network callbacks will ever write directly to the state.
3. **Changes are made with pure functions:** To specify how the state tree is transformed by actions, you write reducers. Reducers are just pure functions that take the previous state and an action as parameters, and return the next state.

[**⬆ Back to Top**](#table-of-contents)

### **What are the downsides of Redux compared to Flux?**

Instead of saying downsides we can say that there are few compromises of using Redux over Flux. Those are as follows:

1. **You will need to learn to avoid mutations:** Flux is un-opinionated about mutating data, but Redux doesn't like mutations and many packages complementary to Redux assume you never mutate the state. You can enforce this with dev-only packages like redux-immutable-state-invariant, Immutable.js, or instructing your team to write non-mutating code.
2. **You're going to have to carefully pick your packages:** While Flux explicitly doesn't try to solve problems such as undo/redo, persistence, or forms, Redux has extension points such as middleware and store enhancers, and it has spawned a rich ecosystem.
3. **There is no nice Flow integration yet:** Flux currently lets you do very impressive static type checks which Redux doesn't support yet.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between mapStateToProps() and mapDispatchToProps()?**

mapStateToProps() is a utility which helps your component get updated state (which is updated by some other components):

const mapStateToProps = (state) => {

return {

todos: getVisibleTodos(state.todos, state.visibilityFilter),

};

};

mapDispatchToProps() is a utility which will help your component to fire an action event (dispatching action which may cause change of application state):

const mapDispatchToProps = (dispatch) => {

return {

onTodoClick: (id) => {

dispatch(toggleTodo(id));

},

};

};

Recommend always using the “object shorthand” form for the mapDispatchToProps

Redux wrap it in another function that looks like (…args) => dispatch(onTodoClick(…args)), and pass that wrapper function as a prop to your component.

const mapDispatchToProps = {

onTodoClick,

};

[**⬆ Back to Top**](#table-of-contents)

### **Can I dispatch an action in reducer?**

Dispatching an action within a reducer is an **anti-pattern**. Your reducer should be _without side effects_, simply digesting the action payload and returning a new state object. Adding listeners and dispatching actions within the reducer can lead to chained actions and other side effects.

[**⬆ Back to Top**](#table-of-contents)

### **How to access Redux store outside a component?**

You just need to export the store from the module where it created with createStore(). Also, it shouldn't pollute the global window object.

store = createStore(myReducer);

export default store;

[**⬆ Back to Top**](#table-of-contents)

### **What are the drawbacks of MVW pattern?**

1. DOM manipulation is very expensive which causes applications to behave slow and inefficient.
2. Due to circular dependencies, a complicated model was created around models and views.
3. Lot of data changes happens for collaborative applications(like Google Docs).
4. No way to do undo (travel back in time) easily without adding so much extra code.

[**⬆ Back to Top**](#table-of-contents)

### **Are there any similarities between Redux and RxJS?**

These libraries are very different for very different purposes, but there are some vague similarities.

Redux is a tool for managing state throughout the application. It is usually used as an architecture for UIs. Think of it as an alternative to (half of) Angular. RxJS is a reactive programming library. It is usually used as a tool to accomplish asynchronous tasks in JavaScript. Think of it as an alternative to Promises. Redux uses the Reactive paradigm because the Store is reactive. The Store observes actions from a distance, and changes itself. RxJS also uses the Reactive paradigm, but instead of being an architecture, it gives you basic building blocks, Observables, to accomplish this pattern.

[**⬆ Back to Top**](#table-of-contents)

### **How to dispatch an action on load?**

You can dispatch an action in componentDidMount() method and in render() method you can verify the data.

class App extends Component {

componentDidMount() {

this.props.fetchData();

}

render() {

return this.props.isLoaded ? <div>{'Loaded'}</div> : <div>{'Not Loaded'}</div>;

}

}

const mapStateToProps = (state) => ({

isLoaded: state.isLoaded,

});

const mapDispatchToProps = { fetchData };

export default connect(mapStateToProps, mapDispatchToProps)(App);

[**⬆ Back to Top**](#table-of-contents)

### **How to use connect() from React Redux?**

You need to follow two steps to use your store in your container:

1. **Use mapStateToProps():** It maps the state variables from your store to the props that you specify.
2. **Connect the above props to your container:** The object returned by the mapStateToProps function is connected to the container. You can import connect() from react-redux.

import React from 'react';

import { connect } from 'react-redux';

class App extends React.Component {

render() {

return <div>{this.props.containerData}</div>;

}

}

function mapStateToProps(state) {

return { containerData: state.data };

}

export default connect(mapStateToProps)(App);

[**⬆ Back to Top**](#table-of-contents)

### **How to reset state in Redux?**

You need to write a _root reducer_ in your application which delegate handling the action to the reducer generated by combineReducers().

For example, let us take rootReducer() to return the initial state after USER_LOGOUT action. As we know, reducers are supposed to return the initial state when they are called with undefined as the first argument, no matter the action.

const appReducer = combineReducers({

/\* your app's top-level reducers \*/

});

const rootReducer = (state, action) => {

if (action.type === 'USER_LOGOUT') {

state = undefined;

}

return appReducer(state, action);

};

In case of using redux-persist, you may also need to clean your storage. redux-persist keeps a copy of your state in a storage engine. First, you need to import the appropriate storage engine and then, to parse the state before setting it to undefined and clean each storage state key.

const appReducer = combineReducers({

/\* your app's top-level reducers \*/

});

const rootReducer = (state, action) => {

if (action.type === 'USER_LOGOUT') {

Object.keys(state).forEach((key) => {

storage.removeItem(\`persist:${key}\`);

});

state = undefined;

}

return appReducer(state, action);

};

[**⬆ Back to Top**](#table-of-contents)

### **Whats the purpose of at symbol in the Redux connect decorator?**

The **@** symbol is in fact a JavaScript expression used to signify decorators. _Decorators_ make it possible to annotate and modify classes and properties at design time.

Let's take an example setting up Redux without and with a decorator.

- **Without decorator:**

import React from 'react';

import \* as actionCreators from './actionCreators';

import { bindActionCreators } from 'redux';

import { connect } from 'react-redux';

function mapStateToProps(state) {

return { todos: state.todos };

}

function mapDispatchToProps(dispatch) {

return { actions: bindActionCreators(actionCreators, dispatch) };

}

class MyApp extends React.Component {

// ...define your main app here

}

export default connect(mapStateToProps, mapDispatchToProps)(MyApp);

- **With decorator:**

import React from 'react';

import \* as actionCreators from './actionCreators';

import { bindActionCreators } from 'redux';

import { connect } from 'react-redux';

function mapStateToProps(state) {

return { todos: state.todos };

}

function mapDispatchToProps(dispatch) {

return { actions: bindActionCreators(actionCreators, dispatch) };

}

@connect(mapStateToProps, mapDispatchToProps)

export default class MyApp extends React.Component {

// ...define your main app here

}

The above examples are almost similar except the usage of decorator. The decorator syntax isn't built into any JavaScript runtimes yet, and is still experimental and subject to change. You can use babel for the decorators support.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between React context and React Redux?**

You can use **Context** in your application directly and is going to be great for passing down data to deeply nested components which what it was designed for.

Whereas **Redux** is much more powerful and provides a large number of features that the Context API doesn't provide. Also, React Redux uses context internally but it doesn't expose this fact in the public API.

[**⬆ Back to Top**](#table-of-contents)

### **Why are Redux state functions called reducers?**

Reducers always return the accumulation of the state (based on all previous and current actions). Therefore, they act as a reducer of state. Each time a Redux reducer is called, the state and action are passed as parameters. This state is then reduced (or accumulated) based on the action, and then the next state is returned. You could _reduce_ a collection of actions and an initial state (of the store) on which to perform these actions to get the resulting final state.

[**⬆ Back to Top**](#table-of-contents)

### **How to make AJAX request in Redux?**

You can use redux-thunk middleware which allows you to define async actions.

Let's take an example of fetching specific account as an AJAX call using _fetch API_:

export function fetchAccount(id) {

return (dispatch) => {

dispatch(setLoadingAccountState()); // Show a loading spinner

fetch(\`/account/${id}\`, (response) => {

dispatch(doneFetchingAccount()); // Hide loading spinner

if (response.status === 200) {

dispatch(setAccount(response.json)); // Use a normal function to set the received state

} else {

dispatch(someError);

}

});

};

}

function setAccount(data) {

return { type: 'SET_Account', data: data };

}

[**⬆ Back to Top**](#table-of-contents)

### **Should I keep all component's state in Redux store?**

Keep your data in the Redux store, and the UI related state internally in the component.

[**⬆ Back to Top**](#table-of-contents)

### **What is the proper way to access Redux store?**

The best way to access your store in a component is to use the connect() function, that creates a new component that wraps around your existing one. This pattern is called _Higher-Order Components_, and is generally the preferred way of extending a component's functionality in React. This allows you to map state and action creators to your component, and have them passed in automatically as your store updates.

Let's take an example of <FilterLink> component using connect:

import { connect } from 'react-redux';

import { setVisibilityFilter } from '../actions';

import Link from '../components/Link';

const mapStateToProps = (state, ownProps) => ({

active: ownProps.filter === state.visibilityFilter,

});

const mapDispatchToProps = (dispatch, ownProps) => ({

onClick: () => dispatch(setVisibilityFilter(ownProps.filter)),

});

const FilterLink = connect(mapStateToProps, mapDispatchToProps)(Link);

export default FilterLink;

Due to it having quite a few performance optimizations and generally being less likely to cause bugs, the Redux developers almost always recommend using connect() over accessing the store directly (using context API).

class MyComponent {

someMethod() {

doSomethingWith(this.context.store);

}

}

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between component and container in React Redux?**

**Component** is a class or function component that describes the presentational part of your application.

**Container** is an informal term for a component that is connected to a Redux store. Containers _subscribe_ to Redux state updates and _dispatch_ actions, and they usually don't render DOM elements; they delegate rendering to presentational child components.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of the constants in Redux?**

Constants allows you to easily find all usages of that specific functionality across the project when you use an IDE. It also prevents you from introducing silly bugs caused by typos – in which case, you will get a ReferenceError immediately.

Normally we will save them in a single file (constants.js or actionTypes.js).

export const ADD_TODO = 'ADD_TODO';

export const DELETE_TODO = 'DELETE_TODO';

export const EDIT_TODO = 'EDIT_TODO';

export const COMPLETE_TODO = 'COMPLETE_TODO';

export const COMPLETE_ALL = 'COMPLETE_ALL';

export const CLEAR_COMPLETED = 'CLEAR_COMPLETED';

In Redux, you use them in two places:

1. **During action creation:**

Let's take actions.js:

import { ADD_TODO } from './actionTypes';

export function addTodo(text) {

return { type: ADD_TODO, text };

}

1. **In reducers:**

Let's create reducer.js:

import { ADD_TODO } from './actionTypes';

export default (state = \[\], action) => {

switch (action.type) {

case ADD_TODO:

return \[

...state,

{

text: action.text,

completed: false,

},

\];

default:

return state;

}

};

[**⬆ Back to Top**](#table-of-contents)

### **What are the different ways to write mapDispatchToProps()?**

There are a few ways of binding _action creators_ to dispatch() in mapDispatchToProps().

Below are the possible options:

const mapDispatchToProps = (dispatch) => ({

action: () => dispatch(action()),

});

const mapDispatchToProps = (dispatch) => ({

action: bindActionCreators(action, dispatch),

});

const mapDispatchToProps = { action };

The third option is just a shorthand for the first one.

[**⬆ Back to Top**](#table-of-contents)

### **What is the use of the ownProps parameter in mapStateToProps() and mapDispatchToProps()?**

If the ownProps parameter is specified, React Redux will pass the props that were passed to the component into your _connect_ functions. So, if you use a connected component:

import ConnectedComponent from './containers/ConnectedComponent';

<ConnectedComponent user={'john'} />;

The ownProps inside your mapStateToProps() and mapDispatchToProps() functions will be an object:

{

user: 'john';

}

You can use this object to decide what to return from those functions.

[**⬆ Back to Top**](#table-of-contents)

### **How to structure Redux top level directories?**

Most of the applications has several top-level directories as below:

1. **Components**: Used for _dumb_ components unaware of Redux.
2. **Containers**: Used for _smart_ components connected to Redux.
3. **Actions**: Used for all action creators, where file names correspond to part of the app.
4. **Reducers**: Used for all reducers, where files name correspond to state key.
5. **Store**: Used for store initialization.

This structure works well for small and medium size apps.

[**⬆ Back to Top**](#table-of-contents)

### **What is redux-saga?**

redux-saga is a library that aims to make side effects (asynchronous things like data fetching and impure things like accessing the browser cache) in React/Redux applications easier and better.

It is available in NPM:

$ npm install --save redux-saga

[**⬆ Back to Top**](#table-of-contents)

### **What is the mental model of redux-saga?**

_Saga_ is like a separate thread in your application, that's solely responsible for side effects. redux-saga is a redux _middleware_, which means this thread can be started, paused and cancelled from the main application with normal Redux actions, it has access to the full Redux application state and it can dispatch Redux actions as well.

[**⬆ Back to Top**](#table-of-contents)

### **What are the differences between call() and put() in redux-saga?**

Both call() and put() are effect creator functions. call() function is used to create effect description, which instructs middleware to call the promise. put() function creates an effect, which instructs middleware to dispatch an action to the store.

Let's take example of how these effects work for fetching particular user data.

function\* fetchUserSaga(action) {

// \`call\` function accepts rest arguments, which will be passed to \`api.fetchUser\` function.

// Instructing middleware to call promise, it resolved value will be assigned to \`userData\` variable

const userData = yield call(api.fetchUser, action.userId);

// Instructing middleware to dispatch corresponding action.

yield put({

type: 'FETCH_USER_SUCCESS',

userData,

});

}

[**⬆ Back to Top**](#table-of-contents)

### **What is Redux Thunk?**

_Redux Thunk_ middleware allows you to write action creators that return a function instead of an action. The thunk can be used to delay the dispatch of an action, or to dispatch only if a certain condition is met. The inner function receives the store methods dispatch() and getState() as parameters.

[**⬆ Back to Top**](#table-of-contents)

### **What are the differences between redux-saga and redux-thunk?**

Both _Redux Thunk_ and _Redux Saga_ take care of dealing with side effects. In most of the scenarios, Thunk uses _Promises_ to deal with them, whereas Saga uses _Generators_. Thunk is simple to use and Promises are familiar to many developers, Sagas/Generators are more powerful but you will need to learn them. But both middleware can coexist, so you can start with Thunks and introduce Sagas when/if you need them.

[**⬆ Back to Top**](#table-of-contents)

### **What is Redux DevTools?**

_Redux DevTools_ is a live-editing time travel environment for Redux with hot reloading, action replay, and customizable UI. If you don't want to bother with installing Redux DevTools and integrating it into your project, consider using Redux DevTools Extension for Chrome and Firefox.

[**⬆ Back to Top**](#table-of-contents)

### **What are the features of Redux DevTools?**

Some of the main features of Redux DevTools are below,

1. Lets you inspect every state and action payload.
2. Lets you go back in time by _cancelling_ actions.
3. If you change the reducer code, each _staged_ action will be re-evaluated.
4. If the reducers throw, you will see during which action this happened, and what the error was.
5. With persistState() store enhancer, you can persist debug sessions across page reloads.

[**⬆ Back to Top**](#table-of-contents)

### **What are Redux selectors and why to use them?**

_Selectors_ are functions that take Redux state as an argument and return some data to pass to the component.

For example, to get user details from the state:

const getUserData = (state) => state.user.data;

These selectors have two main benefits,

1. The selector can compute derived data, allowing Redux to store the minimal possible state
2. The selector is not recomputed unless one of its arguments changes

[**⬆ Back to Top**](#table-of-contents)

### **What is Redux Form?**

_Redux Form_ works with React and Redux to enable a form in React to use Redux to store all of its state. Redux Form can be used with raw HTML5 inputs, but it also works very well with common UI frameworks like Material UI, React Widgets and React Bootstrap.

[**⬆ Back to Top**](#table-of-contents)

### **What are the main features of Redux Form?**

Some of the main features of Redux Form are:

1. Field values persistence via Redux store.
2. Validation (sync/async) and submission.
3. Formatting, parsing and normalization of field values.

[**⬆ Back to Top**](#table-of-contents)

### **How to add multiple middlewares to Redux?**

You can use applyMiddleware().

For example, you can add redux-thunk and logger passing them as arguments to applyMiddleware():

import { createStore, applyMiddleware } from 'redux';

const createStoreWithMiddleware = applyMiddleware(ReduxThunk, logger)(createStore);

[**⬆ Back to Top**](#table-of-contents)

### **How to set initial state in Redux?**

You need to pass initial state as second argument to createStore:

const rootReducer = combineReducers({

todos: todos,

visibilityFilter: visibilityFilter,

});

const initialState = {

todos: \[{ id: 123, name: 'example', completed: false }\],

};

const store = createStore(rootReducer, initialState);

[**⬆ Back to Top**](#table-of-contents)

### **How Relay is different from Redux?**

Relay is similar to Redux in that they both use a single store. The main difference is that relay only manages state originated from the server, and all access to the state is used via _GraphQL_ queries (for reading data) and mutations (for changing data). Relay caches the data for you and optimizes data fetching for you, by fetching only changed data and nothing more.

### **What is an action in Redux?**

_Actions_ are plain JavaScript objects or payloads of information that send data from your application to your store. They are the only source of information for the store. Actions must have a type property that indicates the type of action being performed.

For example, let's take an action which represents adding a new todo item:

{

type: ADD_TODO,

text: 'Add todo item'

}

[**⬆ Back to Top**](#table-of-contents)

**React Native**

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between React Native and React?**

**React** is a JavaScript library, supporting both front end web and being run on the server, for building user interfaces and web applications.

**React Native** is a mobile framework that compiles to native app components, allowing you to build native mobile applications (iOS, Android, and Windows) in JavaScript that allows you to use React to build your components, and implements React under the hood.

[**⬆ Back to Top**](#table-of-contents)

### **How to test React Native apps?**

React Native can be tested only in mobile simulators like iOS and Android. You can run the app in your mobile using expo app ([https://expo.io](https://expo.io/)) Where it syncs using QR code, your mobile and computer should be in same wireless network.

[**⬆ Back to Top**](#table-of-contents)

### **How to do logging in React Native?**

You can use console.log, console.warn, etc. As of React Native v0.29 you can simply run the following to see logs in the console:

$ react-native log-ios

$ react-native log-android

[**⬆ Back to Top**](#table-of-contents)

### **How to debug your React Native?**

Follow the below steps to debug React Native app:

1. Run your application in the iOS simulator.
2. Press Command + D and a webpage should open up at <http://localhost:8081/debugger-ui>.
3. Enable _Pause On Caught Exceptions_ for a better debugging experience.
4. Press Command + Option + I to open the Chrome Developer tools, or open it via View -> Developer -> Developer Tools.
5. You should now be able to debug as you normally would.

**React supported libraries & Integration**

[**⬆ Back to Top**](#table-of-contents)

### **What is reselect and how it works?**

_Reselect_ is a **selector library** (for Redux) which uses _memoization_ concept. It was originally written to compute derived data from Redux-like applications state, but it can't be tied to any architecture or library.

Reselect keeps a copy of the last inputs/outputs of the last call, and recomputes the result only if one of the inputs changes. If the the same inputs are provided twice in a row, Reselect returns the cached output. It's memoization and cache are fully customizable.

[**⬆ Back to Top**](#table-of-contents)

### **What is Flow?**

_Flow_ is a _static type checker_ designed to find type errors in JavaScript. Flow types can express much more fine-grained distinctions than traditional type systems. For example, Flow helps you catch errors involving null, unlike most type systems.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between Flow and PropTypes?**

Flow is a _static analysis tool_ (static checker) which uses a superset of the language, allowing you to add type annotations to all of your code and catch an entire class of bugs at compile time.

PropTypes is a _basic type checker_ (runtime checker) which has been patched onto React. It can't check anything other than the types of the props being passed to a given component. If you want more flexible typechecking for your entire project Flow/TypeScript are appropriate choices.

[**⬆ Back to Top**](#table-of-contents)

### **How to use Font Awesome icons in React?**

The below steps followed to include Font Awesome in React:

1. Install font-awesome:

$ npm install --save font-awesome

1. Import font-awesome in your index.js file:

import 'font-awesome/css/font-awesome.min.css';

1. Add Font Awesome classes in className:

render() {

return <div><i className={'fa fa-spinner'} /></div>

}

[**⬆ Back to Top**](#table-of-contents)

### **What is React Dev Tools?**

_React Developer Tools_ let you inspect the component hierarchy, including component props and state. It exists both as a browser extension (for Chrome and Firefox), and as a standalone app (works with other environments including Safari, IE, and React Native).

The official extensions available for different browsers or environments.

1. **Chrome extension**
2. **Firefox extension**
3. **Standalone app** (Safari, React Native, etc)

[**⬆ Back to Top**](#table-of-contents)

### **Why is DevTools not loading in Chrome for local files?**

If you opened a local HTML file in your browser (file://...) then you must first open _Chrome Extensions_ and check Allow access to file URLs.

[**⬆ Back to Top**](#table-of-contents)

### **How to use Polymer in React?**

You need to follow below steps to use Polymer in React,

1. Create a Polymer element:

<link rel="import" href="../../bower_components/polymer/polymer.html" />;

Polymer({

is: 'calender-element',

ready: function () {

this.textContent = 'I am a calender';

},

});

1. Create the Polymer component HTML tag by importing it in a HTML document, e.g. import it in the index.html of your React application:

<link rel="import" href="./src/polymer-components/calender-element.html" />

1. Use that element in the JSX file:

import React from 'react';

class MyComponent extends React.Component {

render() {

return <calender-element />;

}

}

export default MyComponent;

[**⬆ Back to Top**](#table-of-contents)

### **What are the advantages of React over Vue.js?**

React has the following advantages over Vue.js:

1. Gives more flexibility in large apps developing.
2. Easier to test.
3. Suitable for mobile apps creating.
4. More information and solutions available.

**Note:** The above list of advantages are purely opinionated and it vary based on the professional experience. But they are helpful as base parameters.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between React and Angular?**

Let's see the difference between React and Angular in a table format.

| **React** | **Angular** |
| --- | --- |
| React is a library and has only the View layer | Angular is a framework and has complete MVC functionality |
| React handles rendering on the server side | AngularJS renders only on the client side but Angular 2 and above renders on the server side |
| React uses JSX that looks like HTML in JS which can be confusing | Angular follows the template approach for HTML, which makes code shorter and easy to understand |
| React Native, which is a React type to build mobile applications are faster and more stable | Ionic, Angular's mobile native app is relatively less stable and slower |
| In React, data flows only in one way and hence debugging is easy | In Angular, data flows both way i.e it has two-way data binding between children and parent and hence debugging is often difficult |

**Note:** The above list of differences are purely opinionated and it vary based on the professional experience. But they are helpful as base parameters.

[**⬆ Back to Top**](#table-of-contents)

### **Why React tab is not showing up in DevTools?**

When the page loads, _React DevTools_ sets a global named \__REACT_DEVTOOLS_GLOBAL_HOOK_\_, then React communicates with that hook during initialization. If the website is not using React or if React fails to communicate with DevTools then it won't show up the tab.

[**⬆ Back to Top**](#table-of-contents)

### **What are Styled Components?**

styled-components is a JavaScript library for styling React applications. It removes the mapping between styles and components, and lets you write actual CSS augmented with JavaScript.

[**⬆ Back to Top**](#table-of-contents)

### **Give an example of Styled Components?**

Lets create `<Title>` and <Wrapper> components with specific styles for each.
```jsx
import React from 'react';

import styled from 'styled-components';

// Create a <Title> component that renders an <h1> which is centered, red and sized at 1.5em

const Title = styled.h1\`

font-size: 1.5em;

text-align: center;

color: palevioletred;

\`;
```
// Create a <Wrapper> component that renders a <section> with some padding and a papayawhip background
```jsx
const Wrapper = styled.section\`padding: 4em; background: papayawhip;\`;
```
These two variables, Title and Wrapper, are now components that you can render just like any other react component.
```jsx
<Wrapper>

<Title>{'Lets start first styled component!'}</Title>

</Wrapper>
```
[**⬆ Back to Top**](#table-of-contents)

### **What is Relay?**

Relay is a JavaScript framework for providing a data layer and client-server communication to web applications using the React view layer.

[**⬆ Back to Top**](#table-of-contents)

### **How to use TypeScript in create-react-app application?**

Starting from [react-scripts@2.1.0](mailto:react-scripts@2.1.0) or higher, there is a built-in support for typescript. i.e, create-react-app now supports typescript natively. You can just pass --typescript option as below

npx create-react-app my-app --typescript

\# or

yarn create react-app my-app --typescript

But for lower versions of react scripts, just supply --scripts-version option as react-scripts-ts while you create a new project. react-scripts-ts is a set of adjustments to take the standard create-react-app project pipeline and bring TypeScript into the mix.

Now the project layout should look like the following:

my-app/

├─ .gitignore

├─ images.d.ts

├─ node_modules/

├─ public/

├─ src/

│ └─ ...

├─ package.json

├─ tsconfig.json

├─ tsconfig.prod.json

├─ tsconfig.test.json

└─ tslint.json

**Miscellaneous**

[**⬆ Back to Top**](#table-of-contents)

### **What are the main features of Reselect library?**

Let's see the main features of Reselect library,

1. Selectors can compute derived data, allowing Redux to store the minimal possible state.
2. Selectors are efficient. A selector is not recomputed unless one of its arguments changes.
3. Selectors are composable. They can be used as input to other selectors.

### **Give an example of Reselect usage?**

Let's take calculations and different amounts of a shipment order with the simplified usage of Reselect:

import { createSelector } from 'reselect';

const shopItemsSelector = (state) => state.shop.items;

const taxPercentSelector = (state) => state.shop.taxPercent;

const subtotalSelector = createSelector(shopItemsSelector, (items) =>

items.reduce((acc, item) => acc + item.value, 0),

);

const taxSelector = createSelector(

subtotalSelector,

taxPercentSelector,

(subtotal, taxPercent) => subtotal \* (taxPercent / 100),

);

export const totalSelector = createSelector(subtotalSelector, taxSelector, (subtotal, tax) => ({

total: subtotal + tax,

}));

let exampleState = {

shop: {

taxPercent: 8,

items: \[

{ name: 'apple', value: 1.2 },

{ name: 'orange', value: 0.95 },

\],

},

};

console.log(subtotalSelector(exampleState)); // 2.15

console.log(taxSelector(exampleState)); // 0.172

console.log(totalSelector(exampleState)); // { total: 2.322 }

[**⬆ Back to Top**](#table-of-contents)

### **Does the statics object work with ES6 classes in React?**

No, statics only works with React.createClass():

someComponent = React.createClass({

statics: {

someMethod: function () {

// ..

},

},

});

But you can write statics inside ES6+ classes as below,

class Component extends React.Component {

static propTypes = {

// ...

};

static someMethod() {

// ...

}

}

or writing them outside class as below,

class Component extends React.Component {

....

}

Component.propTypes = {...}

Component.someMethod = function(){....}

[**⬆ Back to Top**](#table-of-contents)

### **Can Redux only be used with React?**

Redux can be used as a data store for any UI layer. The most common usage is with React and React Native, but there are bindings available for Angular, Angular 2, Vue, Mithril, and more. Redux simply provides a subscription mechanism which can be used by any other code.

[**⬆ Back to Top**](#table-of-contents)

### **Do you need to have a particular build tool to use Redux?**

Redux is originally written in ES6 and transpiled for production into ES5 with Webpack and Babel. You should be able to use it regardless of your JavaScript build process. Redux also offers a UMD build that can be used directly without any build process at all.

[**⬆ Back to Top**](#table-of-contents)

### **How Redux Form initialValues get updated from state?**

You need to add enableReinitialize : true setting.

const InitializeFromStateForm = reduxForm({

form: 'initializeFromState',

enableReinitialize: true,

})(UserEdit);

If your initialValues prop gets updated, your form will update too.

[**⬆ Back to Top**](#table-of-contents)

### **How React PropTypes allow different types for one prop?**

You can use oneOfType() method of PropTypes.

For example, the height property can be defined with either string or number type as below:

Component.PropTypes = {

size: PropTypes.oneOfType(\[PropTypes.string, PropTypes.number\]),

};

[**⬆ Back to Top**](#table-of-contents)

### **Can I import an SVG file as react component?**

You can import SVG directly as component instead of loading it as a file. This feature is available with react-scripts@2.0.0 and higher.

import { ReactComponent as Logo } from './logo.svg';

const App = () => (

<div>

{/\* Logo is an actual react component \*/}

<Logo />

</div>

);

**Note**: Don't forget about the curly braces in the import.

[**⬆ Back to Top**](#table-of-contents)

### **Why are inline ref callbacks or functions not recommended?**

If the ref callback is defined as an inline function, it will get called twice during updates, first with null and then again with the DOM element. This is because a new instance of the function is created with each render, so React needs to clear the old ref and set up the new one.

class UserForm extends Component {

handleSubmit = () => {

console.log('Input Value is: ', this.input.value);

};

render() {

return (

<form onSubmit={this.handleSubmit}>

<input type="text" ref={(input) => (this.input = input)} /> // Access DOM input in handle

submit

<button type="submit">Submit</button>

</form>

);

}

}

But our expectation is for the ref callback to get called once, when the component mounts. One quick fix is to use the ES7 class property syntax to define the function

class UserForm extends Component {

handleSubmit = () => {

console.log('Input Value is: ', this.input.value);

};

setSearchInput = (input) => {

this.input = input;

};

render() {

return (

<form onSubmit={this.handleSubmit}>

<input type="text" ref={this.setSearchInput} /> // Access DOM input in handle submit

<button type="submit">Submit</button>

</form>

);

}

}

**Note:** In React v16.3, [**⬆ Back to Top**](#table-of-contents)

### **What is render hijacking in react?**

The concept of render hijacking is the ability to control what a component will output from another component. It actually means that you decorate your component by wrapping it into a Higher-Order component. By wrapping you can inject additional props or make other changes, which can cause changing logic of rendering. It does not actually enables hijacking, but by using HOC you make your component behave in different way.

[**⬆ Back to Top**](#table-of-contents)

### **What are HOC factory implementations?**

There are two main ways of implementing HOCs in React.

1. Props Proxy (PP) and
2. Inheritance Inversion (II).

But they follow different approaches for manipulating the _WrappedComponent_.

**Props Proxy**

In this approach, the render method of the HOC returns a React Element of the type of the WrappedComponent. We also pass through the props that the HOC receives, hence the name **Props Proxy**.

function ppHOC(WrappedComponent) {

return class PP extends React.Component {

render() {

return <WrappedComponent {...this.props} />;

}

};

}

**Inheritance Inversion**

In this approach, the returned HOC class (Enhancer) extends the WrappedComponent. It is called Inheritance Inversion because instead of the WrappedComponent extending some Enhancer class, it is passively extended by the Enhancer. In this way the relationship between them seems **inverse**.

function iiHOC(WrappedComponent) {

return class Enhancer extends WrappedComponent {

render() {

return super.render();

}

};

}

[**⬆ Back to Top**](#table-of-contents)

### **How to pass numbers to React component?**

You should be passing the numbers via curly braces({}) where as strings in quotes

React.render(<User age={30} department={'IT'} />, document.getElementById('container'));

[**⬆ Back to Top**](#table-of-contents)

### **Do I need to keep all my state into Redux? Should I ever use react internal state?**

It is up to developer decision. i.e, It is developer job to determine what kinds of state make up your application, and where each piece of state should live. Some users prefer to keep every single piece of data in Redux, to maintain a fully serializable and controlled version of their application at all times. Others prefer to keep non-critical or UI state, such as “is this dropdown currently open”, inside a component's internal state.

Below are the thumb rules to determine what kind of data should be put into Redux

1. Do other parts of the application care about this data?
2. Do you need to be able to create further derived data based on this original data?
3. Is the same data being used to drive multiple components?
4. Is there value to you in being able to restore this state to a given point in time (ie, time travel debugging)?
5. Do you want to cache the data (i.e, use what's in state if it's already there instead of re-requesting it)?

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of registerServiceWorker in React?**

React creates a service worker for you without any configuration by default. The service worker is a web API that helps you cache your assets and other files so that when the user is offline or on slow network, he/she can still see results on the screen, as such, it helps you build a better user experience, that's what you should know about service worker's for now. It's all about adding offline capabilities to your site.

import React from 'react';

import ReactDOM from 'react-dom';

import App from './App';

import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));

registerServiceWorker();

[**⬆ Back to Top**](#table-of-contents)

### **What is React memo function?**

Class components can be restricted from rendering when their input props are the same using **PureComponent or shouldComponentUpdate**. Now you can do the same with function components by wrapping them in **React.memo**.

const MyComponent = React.memo(function MyComponent(props) {

/\* only rerenders if props change \*/

});

[**⬆ Back to Top**](#table-of-contents)

### **What is React lazy function?**

The React.lazy function lets you render an dynamic import as a regular component. It will automatically load the bundle containing the OtherComponent when the component gets rendered. This must return a Promise which resolves to a module with a default export containing a React component.

const OtherComponent = React.lazy(() => import('./OtherComponent'));

function MyComponent() {

return (

<div>

<OtherComponent />

</div>

);

}

**Note:** React.lazy and Suspense is not yet available for server-side rendering. If you want to do code-splitting in a server rendered app, we still recommend React Loadable.

[**⬆ Back to Top**](#table-of-contents)

### **How to prevent unnecessary updates using setState?**

You can compare current value of the state with an existing state value and decide whether to rerender the page or not. If the values are same then you need to return **null** to stop re-rendering otherwise return the latest state value.

For example, the user profile information is conditionally rendered as follows,

getUserProfile = (user) => {

const latestAddress = user.address;

this.setState((state) => {

if (state.address === latestAddress) {

return null;

} else {

return { title: latestAddress };

}

});

};

[**⬆ Back to Top**](#table-of-contents)

### **How do you render Array, Strings and Numbers in React 16 Version?**

**Arrays**: Unlike older releases, you don't need to make sure **render** method return a single element in React16. You are able to return multiple sibling elements without a wrapping element by returning an array.

For example, let us take the below list of developers,

const ReactJSDevs = () => {

return \[<li key="1">John</li>, <li key="2">Jackie</li>, <li key="3">Jordan</li>\];

};

You can also merge this array of items in another array component.

const JSDevs = () => {

return (

<ul>

<li>Brad</li>

<li>Brodge</li>

<ReactJSDevs />

<li>Brandon</li>

</ul>

);

};

**Strings and Numbers:** You can also return string and number type from the render method.

render() {

return 'Welcome to ReactJS questions';

}

// Number

render() {

return 2018;

}

[**⬆ Back to Top**](#table-of-contents)

### **How to use class field declarations syntax in React classes?**

React Class Components can be made much more concise using the class field declarations. You can initialize local state without using the constructor and declare class methods by using arrow functions without the extra need to bind them.

Let's take a counter example to demonstrate class field declarations for state without using constructor and methods without binding,

class Counter extends Component {

state = { value: 0 };

handleIncrement = () => {

this.setState((prevState) => ({

value: prevState.value + 1,

}));

};

handleDecrement = () => {

this.setState((prevState) => ({

value: prevState.value - 1,

}));

};

render() {

return (

<div>

{this.state.value}

<button onClick={this.handleIncrement}>+</button>

<button onClick={this.handleDecrement}>-</button>

</div>

);

}

}

[**⬆ Back to Top**](#table-of-contents)

### **What are hooks?**

Hooks is a new feature(React 16.8) that lets you use state and other React features without writing a class.

Let's see an example of useState hook example,

import { useState } from 'react';

function Example() {

// Declare a new state variable, which we'll call "count"

const \[count, setCount\] = useState(0);

return (

<div>

<p>You clicked {count} times</p>

<button onClick={() => setCount(count + 1)}>Click me</button>

</div>

);

}

[**⬆ Back to Top**](#table-of-contents)

### **What are the rules needs to follow for hooks?**

You need to follow two rules in order to use hooks,

1. Call Hooks only at the top level of your react functions. i.e, You shouldn’t call Hooks inside loops, conditions, or nested functions. This will ensure that Hooks are called in the same order each time a component renders and it preserves the state of Hooks between multiple useState and useEffect calls.
2. Call Hooks from React Functions only. i.e, You shouldn’t call Hooks from regular JavaScript functions.

[**⬆ Back to Top**](#table-of-contents)

### **How to ensure hooks followed the rules in your project?**

React team released an ESLint plugin called **eslint-plugin-react-hooks** that enforces these two rules. You can add this plugin to your project using the below command,

npm install eslint-plugin-react-hooks@next

And apply the below config in your ESLint config file,

// Your ESLint configuration

{

"plugins": \[

// ...

"react-hooks"

\],

"rules": {

// ...

"react-hooks/rules-of-hooks": "error"

}

}

**Note:** This plugin is intended to use in Create React App by default.

[**⬆ Back to Top**](#table-of-contents)

### **What are the differences between Flux and Redux?**

Below are the major differences between Flux and Redux

| **Flux** | **Redux** |
| --- | --- |
| State is mutable | State is immutable |
| The Store contains both state and change logic | The Store and change logic are separate |
| There are multiple stores exist | There is only one store exist |
| All the stores are disconnected and flat | Single store with hierarchical reducers |
| It has a singleton dispatcher | There is no concept of dispatcher |
| React components subscribe to the store | Container components uses connect function |

[**⬆ Back to Top**](#table-of-contents)

### **What are the benefits of React Router V4?**

Below are the main benefits of React Router V4 module,

1. In React Router v4(version 4), the API is completely about components. A router can be visualized as a single component(<BrowserRouter>) which wraps specific child router components(<Route>).
2. You don't need to manually set history. The router module will take care history by wrapping routes with <BrowserRouter> component.
3. The application size is reduced by adding only the specific router module(Web, core, or native)

[**⬆ Back to Top**](#table-of-contents)

### **Can you describe about componentDidCatch lifecycle method signature?**

The **componentDidCatch** lifecycle method is invoked after an error has been thrown by a descendant component. The method receives two parameters,

1. error: - The error object which was thrown
2. info: - An object with a componentStack key contains the information about which component threw the error.

The method structure would be as follows

componentDidCatch(error, info);

[**⬆ Back to Top**](#table-of-contents)

### **In which scenarios error boundaries do not catch errors?**

Below are the cases in which error boundaries doesn't work,

1. Inside Event handlers
2. Asynchronous code using **setTimeout or requestAnimationFrame** callbacks
3. During Server side rendering
4. When errors thrown in the error boundary code itself

[**⬆ Back to Top**](#table-of-contents)

### **Why do not you need error boundaries for event handlers?**

Error boundaries do not catch errors inside event handlers. Event handlers don't happened or invoked during rendering time unlike render method or lifecycle methods. So React knows how to recover these kind of errors in event handlers. If still you need to catch an error inside event handler, use the regular JavaScript try / catch statement as below

class MyComponent extends React.Component {

constructor(props) {

super(props);

this.state = { error: null };

}

handleClick = () => {

try {

// Do something that could throw

} catch (error) {

this.setState({ error });

}

};

render() {

if (this.state.error) {

return <h1>Caught an error.</h1>;

}

return <div onClick={this.handleClick}>Click Me</div>;

}

}

The above code is catching the error using vanilla javascript try/catch block instead of error boundaries.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between try catch block and error boundaries?**

Try catch block works with imperative code whereas error boundaries are meant for declarative code to render on the screen.

For example, the try catch block used for below imperative code

try {

showButton();

} catch (error) {

// ...

}

Whereas error boundaries wrap declarative code as below,

<ErrorBoundary>

<MyComponent />

</ErrorBoundary>

So if an error occurs in a **componentDidUpdate** method caused by a **setState** somewhere deep in the tree, it will still correctly propagate to the closest error boundary.

[**⬆ Back to Top**](#table-of-contents)

### **What is the behavior of uncaught errors in react 16?**

In React 16, errors that were not caught by any error boundary will result in unmounting of the whole React component tree. The reason behind this decision is that it is worse to leave corrupted UI in place than to completely remove it. For example, it is worse for a payments app to display a wrong amount than to render nothing.

[**⬆ Back to Top**](#table-of-contents)

### **What is the proper placement for error boundaries?**

The granularity of error boundaries usage is up to the developer based on project needs. You can follow either of these approaches,

1. You can wrap top-level route components to display a generic error message for the entire application.
2. You can also wrap individual components in an error boundary to protect them from crashing the rest of the application.

[**⬆ Back to Top**](#table-of-contents)

### **What is the benefit of component stack trace from error boundary?**

Apart from error messages and javascript stack, React16 will display the component stack trace with file names and line numbers using error boundary concept.

For example, BuggyCounter component displays the component stack trace as below,

![stacktrace](data:image/png;base64,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)

[**⬆ Back to Top**](#table-of-contents)

### **What is the required method to be defined for a class component?**

The render() method is the only required method in a class component. i.e, All methods other than render method are optional for a class component.

[**⬆ Back to Top**](#table-of-contents)

### **What are the possible return types of render method?**

Below are the list of following types used and return from render method,

1. **React elements:** Elements that instruct React to render a DOM node. It includes html elements such as <div/> and user defined elements.
2. **Arrays and fragments:** Return multiple elements to render as Arrays and Fragments to wrap multiple elements
3. **Portals:** Render children into a different DOM subtree.
4. **String and numbers:** Render both Strings and Numbers as text nodes in the DOM
5. **Booleans or null:** Doesn't render anything but these types are used to conditionally render content.

[**⬆ Back to Top**](#table-of-contents)

### **What is the main purpose of constructor?**

The constructor is mainly used for two purposes,

1. To initialize local state by assigning object to this.state
2. For binding event handler methods to the instance For example, the below code covers both the above cases,

constructor(props) {

super(props);

// Don't call this.setState() here!

this.state = { counter: 0 };

this.handleClick = this.handleClick.bind(this);

}

[**⬆ Back to Top**](#table-of-contents)

### **Is it mandatory to define constructor for React component?**

No, it is not mandatory. i.e, If you don’t initialize state and you don’t bind methods, you don’t need to implement a constructor for your React component.

[**⬆ Back to Top**](#table-of-contents)

### **What are default props?**

The defaultProps are defined as a property on the component class to set the default props for the class. This is used for undefined props, but not for null props.

For example, let us create color default prop for the button component,

class MyButton extends React.Component {

// ...

}

MyButton.defaultProps = {

color: 'red',

};

If props.color is not provided then it will set the default value to 'red'. i.e, Whenever you try to access the color prop it uses default value

render() {

return <MyButton /> ; // props.color will be set to red

}

**Note:** If you provide null value then it remains null value.

[**⬆ Back to Top**](#table-of-contents)

### **Why should not call setState in componentWillUnmount?**

You should not call setState() in componentWillUnmount() because once a component instance is unmounted, it will never be mounted again.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of getDerivedStateFromError?**

This lifecycle method is invoked after an error has been thrown by a descendant component. It receives the error that was thrown as a parameter and should return a value to update state.

The signature of the lifecycle method is as follows,

static getDerivedStateFromError(error)

Let us take error boundary use case with the above lifecycle method for demonistration purpose,

class ErrorBoundary extends React.Component {

constructor(props) {

super(props);

this.state = { hasError: false };

}

static getDerivedStateFromError(error) {

// Update state so the next render will show the fallback UI.

return { hasError: true };

}

render() {

if (this.state.hasError) {

// You can render any custom fallback UI

return <h1>Something went wrong.</h1>;

}

return this.props.children;

}

}

[**⬆ Back to Top**](#table-of-contents)

### **What is the methods order when component re-rendered?**

An update can be caused by changes to props or state. The below methods are called in the following order when a component is being re-rendered.

1. static getDerivedStateFromProps()
2. shouldComponentUpdate()
3. render()
4. getSnapshotBeforeUpdate()
5. componentDidUpdate()

[**⬆ Back to Top**](#table-of-contents)

### **What are the methods invoked during error handling?**

Below methods are called when there is an error during rendering, in a lifecycle method, or in the constructor of any child component.

1. static getDerivedStateFromError()
2. componentDidCatch()

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of displayName class property?**

The displayName string is used in debugging messages. Usually, you don’t need to set it explicitly because it’s inferred from the name of the function or class that defines the component. You might want to set it explicitly if you want to display a different name for debugging purposes or when you create a higher-order component.

For example, To ease debugging, choose a display name that communicates that it’s the result of a withSubscription HOC.

function withSubscription(WrappedComponent) {

class WithSubscription extends React.Component {

/\* ... \*/

}

WithSubscription.displayName = \`WithSubscription(${getDisplayName(WrappedComponent)})\`;

return WithSubscription;

}

function getDisplayName(WrappedComponent) {

return WrappedComponent.displayName || WrappedComponent.name || 'Component';

}

[**⬆ Back to Top**](#table-of-contents)

### **What is the browser support for react applications?**

React supports all popular browsers, including Internet Explorer 9 and above, although some polyfills are required for older browsers such as IE 9 and IE 10. If you use **es5-shim and es5-sham** polyfill then it even support old browsers that doesn't support ES5 methods.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of unmountComponentAtNode method?**

This method is available from react-dom package and it removes a mounted React component from the DOM and clean up its event handlers and state. If no component was mounted in the container, calling this function does nothing. Returns true if a component was unmounted and false if there was no component to unmount.

The method signature would be as follows,

ReactDOM.unmountComponentAtNode(container);

[**⬆ Back to Top**](#table-of-contents)

### **What is code-splitting?**

Code-Splitting is a feature supported by bundlers like Webpack and Browserify which can create multiple bundles that can be dynamically loaded at runtime. The react project supports code splitting via dynamic import() feature.

For example, in the below code snippets, it will make moduleA.js and all its unique dependencies as a separate chunk that only loads after the user clicks the 'Load' button. **moduleA.js**

const moduleA = 'Hello';

export { moduleA };

**App.js**

import React, { Component } from 'react';

class App extends Component {

handleClick = () => {

import('./moduleA')

.then(({ moduleA }) => {

// Use moduleA

})

.catch((err) => {

// Handle failure

});

};

render() {

return (

<div>

<button onClick={this.handleClick}>Load</button>

</div>

);

}

}

export default App;

[**⬆ Back to Top**](#table-of-contents)

### **What is the benefit of strict mode?**

The will be helpful in the below cases

1. Identifying components with **unsafe lifecycle methods**.
2. Warning about **legacy string ref** API usage.
3. Detecting unexpected **side effects**.
4. Detecting **legacy context** API.
5. Warning about deprecated findDOMNode usage

[**⬆ Back to Top**](#table-of-contents)

### **What are Keyed Fragments?**

The Fragments declared with the explicit syntax may have keys. The general use case is mapping a collection to an array of fragments as below,

function Glossary(props) {

return (

<dl>

{props.items.map((item) => (

// Without the \`key\`, React will fire a key warning

<React.Fragment key={item.id}>

<dt>{item.term}</dt>

<dd>{item.description}</dd>

</React.Fragment>

))}

</dl>

);

}

**Note:** key is the only attribute that can be passed to Fragment. In the future, there might be a support for additional attributes, such as event handlers.

[**⬆ Back to Top**](#table-of-contents)

### **Does React support all HTML attributes?**

As of React 16, both standard or custom DOM attributes are fully supported. Since React components often take both custom and DOM-related props, React uses the camelCase convention just like the DOM APIs.

Let us take few props with respect to standard HTML attributes,

<div tabIndex="-1" /> // Just like node.tabIndex DOM API

<div className="Button" /> // Just like node.className DOM API

<input readOnly={true} /> // Just like node.readOnly DOM API

These props work similarly to the corresponding HTML attributes, with the exception of the special cases. It also support all SVG attributes.

[**⬆ Back to Top**](#table-of-contents)

### **What are the limitations with HOCs?**

Higher-order components come with a few caveats apart from its benefits. Below are the few listed in an order,

1. **Don’t use HOCs inside the render method:** It is not recommended to apply a HOC to a component within the render method of a component.

render() {

// A new version of EnhancedComponent is created on every render

// EnhancedComponent1 !== EnhancedComponent2

const EnhancedComponent = enhance(MyComponent);

// That causes the entire subtree to unmount/remount each time!

return <EnhancedComponent />;

}

The above code impact performance by remounting a component that causes the state of that component and all of its children to be lost. Instead, apply HOCs outside the component definition so that the resulting component is created only once.

1. **Static methods must be copied over:** When you apply a HOC to a component the new component does not have any of the static methods of the original component

// Define a static method

WrappedComponent.staticMethod = function () {

/\*...\*/

};

// Now apply a HOC

const EnhancedComponent = enhance(WrappedComponent);

// The enhanced component has no static method

typeof EnhancedComponent.staticMethod === 'undefined'; // true

You can overcome this by copying the methods onto the container before returning it,

function enhance(WrappedComponent) {

class Enhance extends React.Component {

/\*...\*/

}

// Must know exactly which method(s) to copy :(

Enhance.staticMethod = WrappedComponent.staticMethod;

return Enhance;

}

1. **Refs aren’t passed through:** For HOCs you need to pass through all props to the wrapped component but this does not work for refs. This is because ref is not really a prop similar to key. In this case you need to use the React.forwardRef API

[**⬆ Back to Top**](#table-of-contents)

### **How to debug forwardRefs in DevTools?**

**React.forwardRef** accepts a render function as parameter and DevTools uses this function to determine what to display for the ref forwarding component.

For example, If you don't name the render function or not using displayName property then it will appear as ”ForwardRef” in the DevTools,
```jsx
const WrappedComponent = React.forwardRef((props, ref) => {

return <LogProps {...props} forwardedRef={ref} />;

});
```
But If you name the render function then it will appear as **”ForwardRef(myFunction)”**

const WrappedComponent = React.forwardRef(function myFunction(props, ref) {

return <LogProps {...props} forwardedRef={ref} />;

});

As an alternative, You can also set displayName property for forwardRef function,
```jsx
function logProps(Component) {

class LogProps extends React.Component {

// ...

}

function forwardRef(props, ref) {

return <LogProps {...props} forwardedRef={ref} />;

}

// Give this component a more helpful display name in DevTools.

// e.g. "ForwardRef(logProps(MyComponent))"

const name = Component.displayName || Component.name;

forwardRef.displayName = \`logProps(${name})\`;

return React.forwardRef(forwardRef);

}
```
[**⬆ Back to Top**](#table-of-contents)

### **When component props defaults to true?**

If you pass no value for a prop, it defaults to true. This behavior is available so that it matches the behavior of HTML.

For example, below expressions are equivalent,

<MyInput autocomplete />

<MyInput autocomplete={true} />

**Note:** It is not recommended to use this approach because it can be confused with the ES6 object shorthand (example, {name} which is short for {name: name})

[**⬆ Back to Top**](#table-of-contents)

### **What is NextJS and major features of it?**

Next.js is a popular and lightweight framework for static and server‑rendered applications built with React. It also provides styling and routing solutions. Below are the major features provided by NextJS,

1. Server-rendered by default
2. Automatic code splitting for faster page loads
3. Simple client-side routing (page based)
4. Webpack-based dev environment which supports (HMR)
5. Able to implement with Express or any other Node.js HTTP server
6. Customizable with your own Babel and Webpack configurations

[**⬆ Back to Top**](#table-of-contents)

### **How do you pass an event handler to a component?**

You can pass event handlers and other functions as props to child components. It can be used in child component as below,

<button onClick="{this.handleClick}"></button>

[**⬆ Back to Top**](#table-of-contents)

### **Is it good to use arrow functions in render methods?**

Yes, You can use. It is often the easiest way to pass parameters to callback functions. But you need to optimize the performance while using it.

class Foo extends Component {
```jsx
handleClick() {

console.log('Click happened');

}

render() {

return <button onClick={() => this.handleClick()}>Click Me</button>;

}

}
```
**Note:** Using an arrow function in render method creates a new function each time the component renders, which may have performance implications

[**⬆ Back to Top**](#table-of-contents)

### **How to prevent a function from being called multiple times?**

If you use an event handler such as **onClick or onScroll** and want to prevent the callback from being fired too quickly, then you can limit the rate at which callback is executed. This can be achieved in the below possible ways,

1. **Throttling:** Changes based on a time based frequency. For example, it can be used using \_.throttle lodash function
2. **Debouncing:** Publish changes after a period of inactivity. For example, it can be used using \_.debounce lodash function
3. **RequestAnimationFrame throttling:** Changes based on requestAnimationFrame. For example, it can be used using raf-schd lodash function

[**⬆ Back to Top**](#table-of-contents)

### **How JSX prevents Injection Attacks?**

React DOM escapes any values embedded in JSX before rendering them. Thus it ensures that you can never inject anything that’s not explicitly written in your application. Everything is converted to a string before being rendered.

For example, you can embed user input as below,

const name = response.potentiallyMaliciousInput;

const element = <h1>{name}</h1>;

This way you can prevent XSS(Cross-site-scripting) attacks in the application.

[**⬆ Back to Top**](#table-of-contents)

### **How do you update rendered elements?**

You can update UI(represented by rendered element) by passing the newly created element to ReactDOM's render method.

For example, lets take a ticking clock example, where it updates the time by calling render method multiple times,
```jsx
function tick() {

const element = (

<div>

<h1>Hello, world!</h1>

<h2>It is {new Date().toLocaleTimeString()}.</h2>

</div>

);

ReactDOM.render(element, document.getElementById('root'));

}

setInterval(tick, 1000);
```
[**⬆ Back to Top**](#table-of-contents)

### **How do you say that props are read only?**

When you declare a component as a function or a class, it must never modify its own props.

Let us take a below capital function,
```jsx
function capital(amount, interest) {

return amount + interest;

}
```
The above function is called “pure” because it does not attempt to change their inputs, and always return the same result for the same inputs. Hence, React has a single rule saying "All React components must act like pure functions with respect to their props."

[**⬆ Back to Top**](#table-of-contents)

### **How do you say that state updates are merged?**

When you call setState() in the component, React merges the object you provide into the current state.

For example, let us take a facebook user with posts and comments details as state variables,
```jsx
constructor(props) {

super(props);

this.state = {

posts: \[\],

comments: \[\]

};

}
```
Now you can update them independently with separate setState() calls as below,
```jsx
componentDidMount() {

fetchPosts().then(response => {

this.setState({

posts: response.posts

});

});

fetchComments().then(response => {

this.setState({

comments: response.comments

});

});

}
```
As mentioned in the above code snippets, this.setState({comments}) updates only comments variable without modifying or replacing posts variable.

[**⬆ Back to Top**](#table-of-contents)

### **How do you pass arguments to an event handler?**

During iterations or loops, it is common to pass an extra parameter to an event handler. This can be achieved through arrow functions or bind method.

Let us take an example of user details updated in a grid,

<button onClick={(e) => this.updateUser(userId, e)}>Update User details</button>

<button onClick={this.updateUser.bind(this, userId)}>Update User details</button>

In both the approaches, the synthetic argument e is passed as a second argument. You need to pass it explicitly for arrow functions and it forwarded automatically for bind method.

[**⬆ Back to Top**](#table-of-contents)

### **How to prevent component from rendering?**

You can prevent component from rendering by returning null based on specific condition. This way it can conditionally render component.
```jsx
function Greeting(props) {

if (!props.loggedIn) {

return null;

}

return <div className="greeting">welcome, {props.name}</div>;

}

class User extends React.Component {

constructor(props) {

super(props);

this.state = {loggedIn: false, name: 'John'};

}

render() {

return (

<div>

//Prevent component render if it is not loggedIn

<Greeting loggedIn={this.state.loggedIn} />

<UserDetails name={this.state.name}>

</div>

);

}
```
In the above example, the greeting component skips its rendering section by applying condition and returning null value.

[**⬆ Back to Top**](#table-of-contents)

### **What are the conditions to safely use the index as a key?**

There are three conditions to make sure, it is safe use the index as a key.

1. The list and items are static– they are not computed and do not change
2. The items in the list have no ids
3. The list is never reordered or filtered.

[**⬆ Back to Top**](#table-of-contents)

### **Is it keys should be globally unique?**

Keys used within arrays should be unique among their siblings but they don’t need to be globally unique. i.e, You can use the same keys with two different arrays.

For example, the below book component uses two arrays with different arrays,
```jsx
function Book(props) {

const index = (

<ul>

{props.pages.map((page) => (

<li key={page.id}>{page.title}</li>

))}

</ul>

);

const content = props.pages.map((page) => (

<div key={page.id}>

<h3>{page.title}</h3>

<p>{page.content}</p>

<p>{page.pageNumber}</p>

</div>

));

return (

<div>

{index}

<hr />

{content}

</div>

);

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the popular choice for form handling?**

Formik is a form library for react which provides solutions such as validation, keeping track of the visited fields, and handling form submission.

In detail, You can categorize them as follows,

1. Getting values in and out of form state
2. Validation and error messages
3. Handling form submission

It is used to create a scalable, performant, form helper with a minimal API to solve annoying stuff.

[**⬆ Back to Top**](#table-of-contents)

### **What are the advantages of formik over redux form library?**

Below are the main reasons to recommend formik over redux form library,

1. The form state is inherently short-term and local, so tracking it in Redux (or any kind of Flux library) is unnecessary.
2. Redux-Form calls your entire top-level Redux reducer multiple times ON EVERY SINGLE KEYSTROKE. This way it increases input latency for large apps.
3. Redux-Form is 22.5 kB minified gzipped whereas Formik is 12.7 kB

[**⬆ Back to Top**](#table-of-contents)

### **Why do you not required to use inheritance?**

In React, it is recommend using composition instead of inheritance to reuse code between components. Both Props and composition give you all the flexibility you need to customize a component’s look and behavior in an explicit and safe way. Whereas, If you want to reuse non-UI functionality between components, it is suggested to extracting it into a separate JavaScript module. Later components import it and use that function, object, or a class, without extending it.

[**⬆ Back to Top**](#table-of-contents)

### **Can I use web components in react application?**

Yes, you can use web components in a react application. Even though many developers won't use this combination, it may require especially if you are using third-party UI components that are written using Web Components.

For example, let us use Vaadin date picker web component as below,
```jsx
import React, { Component } from 'react';

import './App.css';

import '@vaadin/vaadin-date-picker';

class App extends Component {

render() {

return (

<div className="App">

<vaadin-date-picker label="When were you born?"></vaadin-date-picker>

</div>

);

}

}

export default App;
```
[**⬆ Back to Top**](#table-of-contents)

### **What is dynamic import?**

The dynamic import() syntax is a ECMAScript proposal not currently part of the language standard. It is expected to be accepted in the near future. You can achieve code-splitting into your app using dynamic import.

Let's take an example of addition,

1. **Normal Import**
```jsx
import { add } from './math';

console.log(add(10, 20));
```
1. **Dynamic Import**
```jsx
import('./math').then((math) => {

console.log(math.add(10, 20));

});
```
[**⬆ Back to Top**](#table-of-contents)

### **What are loadable components?**

If you want to do code-splitting in a server rendered app, it is recommend to use Loadable Components because React.lazy and Suspense is not yet available for server-side rendering. Loadable lets you render a dynamic import as a regular component.

Lets take an example,
```jsx
import loadable from '@loadable/component';

const OtherComponent = loadable(() => import('./OtherComponent'));

function MyComponent() {

return (

<div>

<OtherComponent />

</div>

);

}
```
Now OtherComponent will be loaded in a separated bundle

[**⬆ Back to Top**](#table-of-contents)

### **What is suspense component?**

If the module containing the dynamic import is not yet loaded by the time parent component renders, you must show some fallback content while you’re waiting for it to load using a loading indicator. This can be done using **Suspense** component.

For example, the below code uses suspense component,
```jsx
const OtherComponent = React.lazy(() => import('./OtherComponent'));

function MyComponent() {

return (

<div>

<Suspense fallback={<div>Loading...</div>}>

<OtherComponent />

</Suspense>

</div>

);

}
```
As mentioned in the above code, Suspense is wrapped above the lazy component.

[**⬆ Back to Top**](#table-of-contents)

### **What is route based code splitting?**

One of the best place to do code splitting is with routes. The entire page is going to re-render at once so users are unlikely to interact with other elements in the page at the same time. Due to this, the user experience won't be disturbed.

Let us take an example of route based website using libraries like React Router with React.lazy,
```jsx
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import React, { Suspense, lazy } from 'react';

const Home = lazy(() => import('./routes/Home'));

const About = lazy(() => import('./routes/About'));

const App = () => (

<Router>

<Suspense fallback={<div>Loading...</div>}>

<Switch>

<Route exact path="/" component={Home} />

<Route path="/about" component={About} />

</Switch>

</Suspense>

</Router>

);
```
In the above code, the code splitting will happen at each route level.

[**⬆ Back to Top**](#table-of-contents)

### **Give an example on How to use context?**

**Context** is designed to share data that can be considered **global** for a tree of React components.

For example, in the code below lets manually thread through a “theme” prop in order to style the Button component.

//Lets create a context with a default theme value "luna"
```jsx
const ThemeContext = React.createContext('luna');

// Create App component where it uses provider to pass theme value in the tree

class App extends React.Component {

render() {

return (

<ThemeContext.Provider value="nova">

<Toolbar />

</ThemeContext.Provider>

);

}

}
```
// A middle component where you don't need to pass theme prop anymore
```jsx
function Toolbar(props) {

return (

<div>

<ThemedButton />

</div>

);

}
```
// Lets read theme value in the button component to use
```jsx
class ThemedButton extends React.Component {

static contextType = ThemeContext;

render() {

return <Button theme={this.context} />;

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of default value in context?**

The defaultValue argument is only used when a component does not have a matching Provider above it in the tree. This can be helpful for testing components in isolation without wrapping them.

Below code snippet provides default theme value as Luna.
```jsx
const MyContext = React.createContext(defaultValue);
```
[**⬆ Back to Top**](#table-of-contents)

### **How do you use contextType?**

ContextType is used to consume the context object. The contextType property can be used in two ways,

1. **contextType as property of class:** The contextType property on a class can be assigned a Context object created by React.createContext(). After that, you can consume the nearest current value of that Context type using this.context in any of the lifecycle methods and render function.

Lets assign contextType property on MyClass as below,
```jsx
class MyClass extends React.Component {

componentDidMount() {

let value = this.context;

/\* perform a side-effect at mount using the value of MyContext \*/

}

componentDidUpdate() {

let value = this.context;

/\* ... \*/

}

componentWillUnmount() {

let value = this.context;

/\* ... \*/

}

render() {

let value = this.context;

/\* render something based on the value of MyContext \*/

}

}

MyClass.contextType = MyContext;
```
1. **Static field** You can use a static class field to initialize your contextType using public class field syntax.
```jsx
class MyClass extends React.Component {

static contextType = MyContext;

render() {

let value = this.context;

/\* render something based on the value \*/

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is a consumer?**

A Consumer is a React component that subscribes to context changes. It requires a function as a child which receives current context value as argument and returns a react node. The value argument passed to the function will be equal to the value prop of the closest Provider for this context above in the tree.

Lets take a simple example,
```jsx
<MyContext.Consumer>

{value => /\* render something based on the context value \*/}

</MyContext.Consumer>
```
[**⬆ Back to Top**](#table-of-contents)

### **How do you solve performance corner cases while using context?**

The context uses reference identity to determine when to re-render, there are some gotchas that could trigger unintentional renders in consumers when a provider’s parent re-renders.

For example, the code below will re-render all consumers every time the Provider re-renders because a new object is always created for value.
```jsx
class App extends React.Component {

render() {

return (

<Provider value={{ something: 'something' }}>

<Toolbar />

</Provider>

);

}

}

This can be solved by lifting up the value to parent state,

class App extends React.Component {

constructor(props) {

super(props);

this.state = {

value: { something: 'something' },

};

}

render() {

return (

<Provider value={this.state.value}>

<Toolbar />

</Provider>

);

}

}
```
[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of forward ref in HOCs?**

Refs will not get passed through because ref is not a prop. It handled differently by React just like **key**. If you add a ref to a HOC, the ref will refer to the outermost container component, not the wrapped component. In this case, you can use Forward Ref API. For example, we can explicitly forward refs to the inner FancyButton component using the React.forwardRef API.

The below HOC logs all props,

```jsx

function logProps(Component) {

class LogProps extends React.Component {

componentDidUpdate(prevProps) {

console.log('old props:', prevProps);

console.log('new props:', this.props);

}

render() {

const {forwardedRef, ...rest} = this.props;

// Assign the custom prop "forwardedRef" as a ref

return <Component ref={forwardedRef} {...rest} />;

}

}

return React.forwardRef((props, ref) => {

return <LogProps {...props} forwardedRef={ref} />;

});

}

```
Let's use this HOC to log all props that get passed to our “fancy button” component,

```jsx

class FancyButton extends React.Component {

focus() {

// ...

}

// ...

}

export default logProps(FancyButton);
```

Now lets create a ref and pass it to FancyButton component. In this case, you can set focus to button element.
```jsx

import FancyButton from './FancyButton';

const ref = React.createRef();

ref.current.focus();

<FancyButton label="Click Me" handleClick={handleClick} ref={ref}/>;

````
[**⬆ Back to Top**](#table-of-contents)

### **Is it ref argument available for all functions or class components?**

Regular function or class components don’t receive the ref argument, and ref is not available in props either. The second ref argument only exists when you define a component with React.forwardRef call.

[**⬆ Back to Top**](#table-of-contents)

### **Why do you need additional care for component libraries while using forward refs?**

When you start using forwardRef in a component library, you should treat it as a breaking change and release a new major version of your library. This is because your library likely has a different behavior such as what refs get assigned to, and what types are exported. These changes can break apps and other libraries that depend on the old behavior.

[**⬆ Back to Top**](#table-of-contents)

### **How to create react class components without ES6?**

If you don’t use ES6 then you may need to use the create-react-class module instead. For default props, you need to define getDefaultProps() as a function on the passed object. Whereas for initial state, you have to provide a separate getInitialState method that returns the initial state.
```jsx
var Greeting = createReactClass({

getDefaultProps: function () {

return {

name: 'Jhohn',

};

},

getInitialState: function () {

return { message: this.props.message };

},

handleClick: function () {

console.log(this.state.message);

},

render: function () {

return <h1>Hello, {this.props.name}</h1>;

},

});
```
**Note:** If you use createReactClass then auto binding is available for all methods. i.e, You don't need to use .bind(this) with in constructor for event handlers.

[**⬆ Back to Top**](#table-of-contents)

### **Is it possible to use react without JSX?**

Yes, JSX is not mandatory for using React. Actually it is convenient when you don’t want to set up compilation in your build environment. Each JSX element is just syntactic sugar for calling React.createElement(component, props, ...children).

For example, let us take a greeting example with JSX,
```jsx
class Greeting extends React.Component {

render() {

return <div>Hello {this.props.message}</div>;

}

}
```
ReactDOM.render(<Greeting message="World" />, document.getElementById('root'));

You can write the same code without JSX as below,
```jsx
class Greeting extends React.Component {

render() {

return React.createElement('div', null, \`Hello ${this.props.message}\`);

}

}

ReactDOM.render(

React.createElement(Greeting, { message: 'World' }, null),

document.getElementById('root'),

);
```
[**⬆ Back to Top**](#table-of-contents)

### **What is diffing algorithm?**

React needs to use algorithms to find out how to efficiently update the UI to match the most recent tree. The diffing algorithms is generating the minimum number of operations to transform one tree into another. However, the algorithms have a complexity in the order of O(n3) where n is the number of elements in the tree.

In this case, for displaying 1000 elements would require in the order of one billion comparisons. This is far too expensive. Instead, React implements a heuristic O(n) algorithm based on two assumptions:

1. Two elements of different types will produce different trees.
2. The developer can hint at which child elements may be stable across different renders with a key prop.

[**⬆ Back to Top**](#table-of-contents)

### **What are the rules covered by diffing algorithm?**

When diffing two trees, React first compares the two root elements. The behavior is different depending on the types of the root elements. It covers the below rules during reconciliation algorithm,

1. **Elements Of Different Types:** Whenever the root elements have different types, React will tear down the old tree and build the new tree from scratch. For example, elements to, or from to of different types lead a full rebuild.
2. **DOM Elements Of The Same Type:** When comparing two React DOM elements of the same type, React looks at the attributes of both, keeps the same underlying DOM node, and only updates the changed attributes. Lets take an example with same DOM elements except className attribute,

<div className="show" title="ReactJS" />

<div className="hide" title="ReactJS" />

1. **Component Elements Of The Same Type:** When a component updates, the instance stays the same, so that state is maintained across renders. React updates the props of the underlying component instance to match the new element, and calls componentWillReceiveProps() and componentWillUpdate() on the underlying instance. After that, the render() method is called and the diff algorithm recurses on the previous result and the new result.
2. **Recursing On Children:** when recursing on the children of a DOM node, React just iterates over both lists of children at the same time and generates a mutation whenever there’s a difference. For example, when adding an element at the end of the children, converting between these two trees works well.
```jsx
<ul>

<li>first</li>

<li>second</li>

</ul>

<ul>

<li>first</li>

<li>second</li>

<li>third</li>

</ul>
```
1. **Handling keys:** React supports a key attribute. When children have keys, React uses the key to match children in the original tree with children in the subsequent tree. For example, adding a key can make the tree conversion efficient,
```jsx
<ul>

<li key="2015">Duke</li>

<li key="2016">Villanova</li>

</ul>

<ul>

<li key="2014">Connecticut</li>

<li key="2015">Duke</li>

<li key="2016">Villanova</li>

</ul>
```
[**⬆ Back to Top**](#table-of-contents)

### **When do you need to use refs?**

There are few use cases to go for refs,

1. Managing focus, text selection, or media playback.
2. Triggering imperative animations.
3. Integrating with third-party DOM libraries.

[**⬆ Back to Top**](#table-of-contents)

### **Is it prop must be named as render for render props?**

Even though the pattern named render props, you don’t have to use a prop named render to use this pattern. i.e, Any prop that is a function that a component uses to know what to render is technically a “render prop”. Lets take an example with the children prop for render props,
```jsx
<Mouse

children={(mouse) => (

<p>

The mouse position is {mouse.x}, {mouse.y}

</p>

)}

/>
```
Actually children prop doesn’t need to be named in the list of “attributes” in JSX element. Instead, you can keep it directly inside element,
```jsx
<Mouse>

{(mouse) => (

<p>

The mouse position is {mouse.x}, {mouse.y}

</p>

)}

</Mouse>
```
While using this above technique(without any name), explicitly state that children should be a function in your propTypes.
```jsx
Mouse.propTypes = {

children: PropTypes.func.isRequired,

};
```
[**⬆ Back to Top**](#table-of-contents)

### **What are the problems of using render props with pure components?**

If you create a function inside a render method, it negates the purpose of pure component. Because the shallow prop comparison will always return false for new props, and each render in this case will generate a new value for the render prop. You can solve this issue by defining the render function as instance method.

[**⬆ Back to Top**](#table-of-contents)

### **How do you create HOC using render props?**

You can implement most higher-order components (HOC) using a regular component with a render prop. For example, if you would prefer to have a withMouse HOC instead of a component, you could easily create one using a regular with a render prop.
```jsx
function withMouse(Component) {

return class extends React.Component {

render() {

return <Mouse render={(mouse) => <Component {...this.props} mouse={mouse} />} />;

}

};

}
```
This way render props gives the flexibility of using either pattern.

[**⬆ Back to Top**](#table-of-contents)

### **What is windowing technique?**

Windowing is a technique that only renders a small subset of your rows at any given time, and can dramatically reduce the time it takes to re-render the components as well as the number of DOM nodes created. If your application renders long lists of data then this technique is recommended. Both react-window and react-virtualized are popular windowing libraries which provides several reusable components for displaying lists, grids, and tabular data.

[**⬆ Back to Top**](#table-of-contents)

### **How do you print falsy values in JSX?**

The falsy values such as false, null, undefined, and true are valid children but they don't render anything. If you still want to display them then you need to convert it to string. Let's take an example on how to convert to a string,

<div>My JavaScript variable is {String(myVariable)}.</div>

[**⬆ Back to Top**](#table-of-contents)

### **What is the typical use case of portals?**

React portals are very useful when a parent component has overflow: hidden or has properties that affect the stacking context(z-index,position,opacity etc styles) and you need to visually “break out” of its container.

For example, dialogs, global message notifications, hovercards, and tooltips.

[**⬆ Back to Top**](#table-of-contents)

### **How do you set default value for uncontrolled component?**

In React, the value attribute on form elements will override the value in the DOM. With an uncontrolled component, you might want React to specify the initial value, but leave subsequent updates uncontrolled. To handle this case, you can specify a **defaultValue** attribute instead of **value**.
```jsx
render() {

return (

<form onSubmit={this.handleSubmit}>

<label>

User Name:

<input

defaultValue="John"

type="text"

ref={this.input} />

</label>

<input type="submit" value="Submit" />

</form>

);

}
```
The same applies for select and textArea inputs. But you need to use **defaultChecked** for checkbox and radio inputs.

[**⬆ Back to Top**](#table-of-contents)

### **What is your favorite React stack?**

Even though the tech stack varies from developer to developer, the most popular stack is used in react boilerplate project code. It mainly uses Redux and redux-saga for state management and asynchronous side-effects, react-router for routing purpose, styled-components for styling react components, axios for invoking REST api, and other supported stack such as webpack, reselect, ESNext, Babel. You can clone the project <https://github.com/react-boilerplate/react-boilerplate> and start working on any new react project.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between Real DOM and Virtual DOM?**

Below are the main differences between Real DOM and Virtual DOM,

| **Real DOM** | **Virtual DOM** |
| --- | --- |
| Updates are slow | Updates are fast |
| DOM manipulation is very expensive. | DOM manipulation is very easy |
| You can update HTML directly. | You Can’t directly update HTML |
| It causes too much of memory wastage | There is no memory wastage |
| Creates a new DOM if element updates | It updates the JSX if element update |

[**⬆ Back to Top**](#table-of-contents)

### **How to add Bootstrap to a react application?**

Bootstrap can be added to your React app in a three possible ways,

1. Using the Bootstrap CDN: This is the easiest way to add bootstrap. Add both bootstrap CSS and JS resources in a head tag.
2. Bootstrap as Dependency: If you are using a build tool or a module bundler such as Webpack, then this is the preferred option for adding Bootstrap to your React application

npm install bootstrap

1. React Bootstrap Package: In this case, you can add Bootstrap to our React app is by using a package that has rebuilt Bootstrap components to work particularly as React components. Below packages are popular in this category,
2. react-bootstrap
3. reactstrap

[**⬆ Back to Top**](#table-of-contents)

### **Can you list down top websites or applications using react as front end framework?**

Below are the top 10 websites using React as their front-end framework,

1. Facebook
2. Uber
3. Instagram
4. WhatsApp
5. Khan Academy
6. Airbnb
7. Dropbox
8. Flipboard
9. Netflix
10. PayPal

[**⬆ Back to Top**](#table-of-contents)

### **Is it recommended to use CSS In JS technique in React?**

React does not have any opinion about how styles are defined but if you are a beginner then good starting point is to define your styles in a separate \*.css file as usual and refer to them using className. This functionality is not part of React but came from third-party libraries. But If you want to try a different approach(CSS-In-JS) then styled-components library is a good option.

[**⬆ Back to Top**](#table-of-contents)

### **Do I need to rewrite all my class components with hooks?**

No. But you can try Hooks in a few components(or new components) without rewriting any existing code. Because there are no plans to remove classes in ReactJS.

[**⬆ Back to Top**](#table-of-contents)

### **How to fetch data with React Hooks?**

The effect hook called useEffect is used to fetch the data with axios from the API and to set the data in the local state of the component with the state hook’s update function.

Let's take an example in which it fetches list of react articles from the API
```jsx
import React, { useState, useEffect } from 'react';

import axios from 'axios';

function App() {

const \[data, setData\] = useState({ hits: \[\] });

useEffect(async () => {

const result = await axios('<http://hn.algolia.com/api/v1/search?query=react>');

setData(result.data);

}, \[\]);

return (

<ul>

{data.hits.map((item) => (

<li key={item.objectID}>

<a href={item.url}>{item.title}</a>

</li>

))}

</ul>

);

}

export default App;
```
Remember we provided an empty array as second argument to the effect hook to avoid activating it on component updates but only for the mounting of the component. i.e, It fetches only for component mount.

[**⬆ Back to Top**](#table-of-contents)

### **Is Hooks cover all use cases for classes?**

Hooks doesn't cover all use cases of classes but there is a plan to add them soon. Currently there are no Hook equivalents to the uncommon **getSnapshotBeforeUpdate** and **componentDidCatch** lifecycles yet.

[**⬆ Back to Top**](#table-of-contents)

### **What is the stable release for hooks support?**

React includes a stable implementation of React Hooks in 16.8 release for below packages

1. React DOM
2. React DOM Server
3. React Test Renderer
4. React Shallow Renderer

[**⬆ Back to Top**](#table-of-contents)

### **Why do we use array destructuring (square brackets notation) in useState?**

When we declare a state variable with useState, it returns a pair — an array with two items. The first item is the current value, and the second is a function that updates the value. Using \[0\] and \[1\] to access them is a bit confusing because they have a specific meaning. This is why we use array destructuring instead.

For example, the array index access would look as follows:

var userStateVariable = useState('userProfile'); // Returns an array pair

var user = userStateVariable\[0\]; // Access first item

var setUser = userStateVariable\[1\]; // Access second item

Whereas with array destructuring the variables can be accessed as follows:

const \[user, setUser\] = useState('userProfile');

[**⬆ Back to Top**](#table-of-contents)

### **What are the sources used for introducing hooks?**

Hooks got the ideas from several different sources. Below are some of them,

1. Previous experiments with functional APIs in the react-future repository
2. Community experiments with render prop APIs such as Reactions Component
3. State variables and state cells in DisplayScript.
4. Subscriptions in Rx.
5. Reducer components in ReasonReact.

[**⬆ Back to Top**](#table-of-contents)

### **How do you access imperative API of web components?**

Web Components often expose an imperative API to implement its functions. You will need to use a **ref** to interact with the DOM node directly if you want to access imperative API of a web component. But if you are using third-party Web Components, the best solution is to write a React component that behaves as a **wrapper** for your Web Component.

[**⬆ Back to Top**](#table-of-contents)

### **What is formik?**

Formik is a small react form library that helps you with the three major problems,

1. Getting values in and out of form state
2. Validation and error messages
3. Handling form submission

[**⬆ Back to Top**](#table-of-contents)

### **What are typical middleware choices for handling asynchronous calls in Redux?**

Some of the popular middleware choices for handling asynchronous calls in Redux eco system are Redux Thunk, Redux Promise, Redux Saga.

[**⬆ Back to Top**](#table-of-contents)

### **Do browsers understand JSX code?**

No, browsers can't understand JSX code. You need a transpiler to convert your JSX to regular Javascript that browsers can understand. The most widely used transpiler right now is Babel.

[**⬆ Back to Top**](#table-of-contents)

### **Describe about data flow in react?**

React implements one-way reactive data flow using props which reduce boilerplate and is easier to understand than traditional two-way data binding.

[**⬆ Back to Top**](#table-of-contents)

### **What is react scripts?**

The react-scripts package is a set of scripts from the create-react-app starter pack which helps you kick off projects without configuring. The react-scripts start command sets up the development environment and starts a server, as well as hot module reloading.

[**⬆ Back to Top**](#table-of-contents)

### **What are the features of create react app?**

Below are the list of some of the features provided by create react app.

1. React, JSX, ES6, Typescript and Flow syntax support.
2. Autoprefixed CSS
3. CSS Reset/Normalize
4. A live development server
5. A fast interactive unit test runner with built-in support for coverage reporting
6. A build script to bundle JS, CSS, and images for production, with hashes and sourcemaps
7. An offline-first service worker and a web app manifest, meeting all the Progressive Web App criteria.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of renderToNodeStream method?**

The ReactDOMServer#renderToNodeStream method is used to generate HTML on the server and send the markup down on the initial request for faster page loads. It also helps search engines to crawl your pages easily for SEO purposes. **Note:** Remember this method is not available in the browser but only server.

[**⬆ Back to Top**](#table-of-contents)

### **What is MobX?**

MobX is a simple, scalable and battle tested state management solution for applying functional reactive programming (TFRP). For reactJs application, you need to install below packages,

npm install mobx --save

npm install mobx-react --save

[**⬆ Back to Top**](#table-of-contents)

### **What are the differences between Redux and MobX?**

Below are the main differences between Redux and MobX,

| **Topic** | **Redux** | **MobX** |
| --- | --- | --- |
| Definition | It is a javascript library for managing the application state | It is a library for reactively managing the state of your applications |
| Programming | It is mainly written in ES6 | It is written in JavaScript(ES5) |
| Data Store | There is only one large store exist for data storage | There is more than one store for storage |
| Usage | Mainly used for large and complex applications | Used for simple applications |
| Performance | Need to be improved | Provides better performance |
| How it stores | Uses JS Object to store | Uses observable to store the data |

[**⬆ Back to Top**](#table-of-contents)

### **Should I learn ES6 before learning ReactJS?**

No, you don’t have to learn es2015/es6 to learn react. But you may find many resources or React ecosystem uses ES6 extensively. Let's see some of the frequently used ES6 features,

1. **Destructuring:** To get props and use them in a component

// in es 5

var someData = this.props.someData;

var dispatch = this.props.dispatch;

// in es6

const { someData, dispatch } = this.props;

1. Spread operator: Helps in passing props down into a component

// in es 5

<SomeComponent someData={this.props.someData} dispatch={this.props.dispatch} />

// in es6

<SomeComponent {...this.props} />

1. Arrow functions: Makes compact syntax

// es 5

var users = usersList.map(function (user) {

return <li>{user.name}</li>;

});

// es 6

const users = usersList.map((user) => <li>{user.name}</li>);

[**⬆ Back to Top**](#table-of-contents)

### **What is Concurrent Rendering?**

The Concurrent rendering makes React apps to be more responsive by rendering component trees without blocking the main UI thread. It allows React to interrupt a long-running render to handle a high-priority event. i.e, When you enabled concurrent Mode, React will keep an eye on other tasks that need to be done, and if there's something with a higher priority it will pause what it is currently rendering and let the other task finish first. You can enable this in two ways,

// 1. Part of an app by wrapping with ConcurrentMode

<React.unstable_ConcurrentMode>

<Something />

</React.unstable_ConcurrentMode>;

// 2. Whole app using createRoot

ReactDOM.unstable_createRoot(domNode).render(<App />);

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between async mode and concurrent mode?**

Both refers the same thing. Previously concurrent Mode being referred to as "Async Mode" by React team. The name has been changed to highlight React’s ability to perform work on different priority levels. So it avoids the confusion from other approaches to Async Rendering.

[**⬆ Back to Top**](#table-of-contents)

### **Can I use javascript urls in react16.9?**

Yes, you can use javascript: URLs but it will log a warning in the console. Because URLs starting with javascript: are dangerous by including unsanitized output in a tag like <a href> and create a security hole.
```jsx
const companyProfile = {

website: "javascript: alert('Your website is hacked')",

};
```
// It will log a warning
```jsx
<a href={companyProfile.website}>More details</a>;
```
Remember that the future versions will throw an error for javascript URLs.

[**⬆ Back to Top**](#table-of-contents)

### **What is the purpose of eslint plugin for hooks?**

The ESLint plugin enforces rules of Hooks to avoid bugs. It assumes that any function starting with ”use” and a capital letter right after it is a Hook. In particular, the rule enforces that,

1. Calls to Hooks are either inside a PascalCase function (assumed to be a component) or another useSomething function (assumed to be a custom Hook).
2. Hooks are called in the same order on every render.

[**⬆ Back to Top**](#table-of-contents)

### **What is the difference between Imperative and Declarative in React?**

Imagine a simple UI component, such as a "Like" button. When you tap it, it turns blue if it was previously grey, and grey if it was previously blue.

The imperative way of doing this would be:
```jsx
if (user.likes()) {

if (hasBlue()) {

removeBlue();

addGrey();

} else {

removeGrey();

addBlue();

}

}
```
Basically, you have to check what is currently on the screen and handle all the changes necessary to redraw it with the current state, including undoing the changes from the previous state. You can imagine how complex this could be in a real-world scenario.

In contrast, the declarative approach would be:
```jsx
if (this.state.liked) {

return <blueLike />;

} else {

return <greyLike />;

}
```
Because the declarative approach separates concerns, this part of it only needs to handle how the UI should look in a sepecific state, and is therefore much simpler to understand.

[**⬆ Back to Top**](#table-of-contents)

### **What are the benefits of using typescript with reactjs?**

Below are some of the benefits of using typescript with Reactjs,

1. It is possible to use latest JavaScript features
2. Use of interfaces for complex type definitions
3. IDEs such as VS Code was made for TypeScript
4. Avoid bugs with the ease of readability and Validation

[**⬆ Back to Top**](#table-of-contents)

### **How do you make sure that user remains authenticated on page refresh while using Context API State Management?**

When a user logs in and reload, to persist the state generally we add the load user action in the useEffect hooks in the main App.js. While using Redux, loadUser action can be easily accessed.

**App.js**
```jsx
import { loadUser } from '../actions/auth';

store.dispatch(loadUser());
```
- But while using **Context API**, to access context in App.js, wrap the AuthState in index.js so that App.js can access the auth context. Now whenever the page reloads, no matter what route you are on, the user will be authenticated as **loadUser** action will be triggered on each re-render.

**index.js**
```jsx
import React from 'react';

import ReactDOM from 'react-dom';

import App from './App';

import AuthState from './context/auth/AuthState';

ReactDOM.render(

<React.StrictMode>

<AuthState>

<App />

</AuthState>

</React.StrictMode>,

document.getElementById('root'),

);
```
**App.js**
```jsx
const authContext = useContext(AuthContext);

const { loadUser } = authContext;

useEffect(() => {

loadUser();

}, \[\]);
```
**loadUser**
```jsx
const loadUser = async () => {

const token = sessionStorage.getItem('token');

if (!token) {

dispatch({

type: ERROR,

});

}

setAuthToken(token);

try {

const res = await axios('/api/auth');

dispatch({

type: USER_LOADED,

payload: res.data.data,

});

} catch (err) {

console.error(err);

}

};
```
[**⬆ Back to Top**](#table-of-contents)

### **What are the benefits of new JSX transform?**

There are three major benefits of new JSX transform,

1. It is possible to use JSX without importing React packages
2. The compiled output might improve the bundle size in a small amount
3. The future improvements provides the flexibility to reduce the number of concepts to learn React.

### **How does new JSX transform different from old transform?**

The new JSX transform doesn’t require React to be in scope. i.e, You don't need to import React package for simple scenarios.

Let's take an example to look at the main differences between the old and the new transform,

**Old Transform:**
```jsx
import React from 'react';

function App() {

return <h1>Good morning!!</h1>;

}
```
Now JSX transform convert the above code into regular JavaScript as below,
```jsx
import React from 'react';

function App() {

return React.createElement('h1', null, 'Good morning!!');

}
```
**New Transform:**

The new JSX transform doesn't require any React imports
```jsx
function App() {

return <h1>Good morning!!</h1>;

}
```
Under the hood JSX transform compiles to below code
```jsx
import { jsx as \_jsx } from 'react/jsx-runtime';

function App() {

return \_jsx('h1', { children: 'Good morning!!' });

}
```
**Note:** You still need to import React to use Hooks.
