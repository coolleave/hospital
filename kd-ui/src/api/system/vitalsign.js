import request from '@/utils/request'

// 查询生命体征列表
export function listVitalsign(query) {
  return request({
    url: '/system/vitalsign/list',
    method: 'get',
    params: query
  })
}

// 查询生命体征详细
export function getVitalsign(Id) {
  return request({
    url: '/system/vitalsign/' + Id,
    method: 'get'
  })
}

// 新增生命体征
export function addVitalsign(data) {
  return request({
    url: '/system/vitalsign',
    method: 'post',
    data: data
  })
}

// 修改生命体征
export function updateVitalsign(data) {
  return request({
    url: '/system/vitalsign',
    method: 'put',
    data: data
  })
}

// 删除生命体征
export function delVitalsign(Id) {
  return request({
    url: '/system/vitalsign/' + Id,
    method: 'delete'
  })
}

// 新增：根据 encounterId 查询生命体征
export function listVitalsignByEncounterId(encounterId) {
  return request({
    url: '/system/vitalsign/list2',
    method: 'get',
    params: { encounterId }
  })
}
