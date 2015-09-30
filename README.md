# boot-slow

## Deps

- (Boot tasks)[git@github.com:allgress/boot-tasks.git] clone from develop branch and run `boot build`

## To demo

- Run `boot web-dev`
- Edit core.cljs and save. The project will take ~8.5s to build. Most of the time taken is before boot even recognizes a file has changed.
