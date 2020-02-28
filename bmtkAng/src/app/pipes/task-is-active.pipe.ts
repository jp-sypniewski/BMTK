import { Task } from 'src/app/models/task';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'taskIsActive'
})
export class TaskIsActivePipe implements PipeTransform {

  transform(value: Task[], showActiveTasks: Boolean): Task[] {
    let filteredTasks: Task[] = [];

    value.forEach((task) => {
      if (task.active) {
        filteredTasks.push(task);
      }
    });

    return filteredTasks;
  }

}
