Introduction to Kubectl CLI Plugins ctx and ns
---
# Kubectl CLI Plugins Installation and Usage
### Table of Contents
* [Introduction](#)
* [Kubectl plugin install steps](#)
* [krew kubectl plugin manager](#)
* [Install krew](#)
* [Install kubectl plugins](#)
* [Plugin usage](#)
* [Plugin Customisation](#)
* [Further Reference](#)

### Introduction
Kubectl is the command line interface to interact with the Kubernetes cluster. As kubectl users, we often find it difficult to switch between contexts and namespaces.

To resolve this difficulty there are plugins available for kubectl CLI, that makes our life easier.

In this blog, we'll see how to install the plugins for kubectl in Ubuntu OS and what is the usage of those plugins.

### Kubectl plugin install steps

### krew kubectl plugin manager
- We can install Krew as a kubectl plugin manager to get the kubectl plugin installed in our system. It is similar to pip for Python and Ubuntu apt package manager.
What does Krew do?
[Krew](https://github.com/kubernetes-sigs/krew/) is a tool that makes it easy to use kubectl plugins. Krew helps you discover plugins, install and manage them on your machine. It is similar to tools like apt, dnf or brew. Today, over 200 kubectl plugins are available on Krew.

### Install krew
- Make sure you've [git is installed](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) in your system.
- Execute the command in your terminal window
```
(
  set -x; cd "$(mktemp -d)" &&
  OS="$(uname | tr '[:upper:]' '[:lower:]')" &&
  ARCH="$(uname -m | sed -e 's/x86_64/amd64/' -e 's/\(arm\)\(64\)\?.*/\1\2/' -e 's/aarch64$/arm64/')" &&
  KREW="krew-${OS}_${ARCH}" &&
  curl -fsSLO "https://github.com/kubernetes-sigs/krew/releases/latest/download/${KREW}.tar.gz" &&
  tar zxvf "${KREW}.tar.gz" &&
  ./"${KREW}" install krew
)
```
- Export the krew bin path to ENV PATH variable
```
export PATH="${KREW_ROOT:-$HOME/.krew}/bin:$PATH"
```
- We have now installed krew as kubectl plugin manager, so let's see how to install plugins using.
### Install kubectl plugins
- Update the krew local packages:
kubectl krew update
- Install ctx plugin to manage contexts:
kubectl krew install ctx
- ctx can be used for kubectl contexts setting and switching.

- Install ns plugin to manage namespaces:
kubectl krew install ns
- Keep your plugins up-to-date by running the command:
kubectl krew upgrade
### Plugin usage
- Check the current context by running the command,
kubectl ctx -c 
- List all the contexts using the command,
kubectl ctx
- Check the current namespace by running the command,
kubectl ns -c 
- List all the namespace using the command,
kubectl ns
- Switch to previous ns or ctx by running the command,
kubectl ns -
kubectl ctx -
### Plugin Customisation
- We can customize the the colors indicating the current namespace or context, by setting color values in the ENV variables KUBECTX_CURRENT_FGCOLOR and KUBECTX_CURRENT_BGCOLOR
- For example:
```
export KUBECTX_CURRENT_FGCOLOR=$(tput setaf 6) # blue text
export KUBECTX_CURRENT_BGCOLOR=$(tput setab 7) # white background
```
- Refer color codes [here](https://linux.101hacks.com/ps1-examples/prompt-color-using-tput/)
### Note

- Add the env variables in .bashrc to access the customised values in terminal sessions permanently,
```
export PATH="${KREW_ROOT:-$HOME/.krew}/bin:$PATH"
export KUBECTX_CURRENT_FGCOLOR=$(tput setaf 6)
export KUBECTX_CURRENT_BGCOLOR=$(tput setab 0)
```
### Further Reference
* [Kubectx GitHub]()
* [Krew Quickstart]()
* [Krew Install]()
* [Krew color codes]()

[PREV](/kubernetes-complete-reference-3.md) - [NEXT](/kubernetes-complete-reference-5.md)
