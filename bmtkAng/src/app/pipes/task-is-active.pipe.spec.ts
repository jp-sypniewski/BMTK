import { TaskIsActivePipe } from './task-is-active.pipe';

describe('TaskIsActivePipe', () => {
  it('create an instance', () => {
    const pipe = new TaskIsActivePipe();
    expect(pipe).toBeTruthy();
  });
});
